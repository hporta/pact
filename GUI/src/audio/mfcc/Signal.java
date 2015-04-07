package audio.mfcc;

import java.io.File;

import WavFile.WavFile;

public class Signal {

	private long size; // nombre d'échantillons du signal
	private long sampleRate; // fréquence d'échantillonnage
	private double[] samples; // échantillons contenus dans le fichier
	private double[] energyPerRaster; // énergie de chaque trame
	private double[] firstCepstralCoefficients; // c(0) de chaque trame
	private Raster[] rasters; // vecteur des trames
	private Raster[] trimmedRasters; // vecteur des trames d'énergie non nulle
	private double[][] cepstres; // vecteur des coefficients cepstraux de chaque trame
	private double[][] realCepstres;
	private int numberOfRasters;
	private int paddedRasterLength;
	
	public Signal(String fileName) {
		
		try {
			
			WavFile file = WavFile.openWavFile(new File(fileName));
			
			size = file.getNumFrames();
			
			sampleRate = file.getSampleRate();
			
			numberOfRasters = (int)(size*100/sampleRate);
			samples = new double[(int)(2*size)];
			file.readFrames(samples, (int)size);
			
			paddedRasterLength = getPaddedRasterLength();
			
			rasters = new Raster[numberOfRasters];
			energyPerRaster = new double[numberOfRasters];
			int p = 0;
			for (int i=0; i<numberOfRasters; i++)
			{
				rasters[i] = new Raster(i, this);
				energyPerRaster[i] = rasters[i].energy();
				if(energyPerRaster[i] != 0.)
					p++;
			}
			
			trimmedRasters = new Raster[p];
			cepstres = new double[p][paddedRasterLength];
			firstCepstralCoefficients = new double[p];
			
			for(int i=0; i<p; i++)
			{
				trimmedRasters[i] = rasters[i];
				cepstres[i] = rasters[i].getCepstre();
				firstCepstralCoefficients[i] = cepstres[i][0];
			}				
			
			
			int[] realSignal = vocalActivityDetection();
			int realLength = realSignal[1]-realSignal[0];
			realCepstres = new double[realLength][paddedRasterLength];
			
			int index = realSignal[0];
			for (int i=0; i<realLength; i++) 
				realCepstres[i] = rasters[index+i].getCepstre();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public long getSampleRate() 
	{
		return sampleRate;
	}
	
	public double[] getSamples() 
	{
		return samples;
	}
	
	public double[] getEnergyPerRaster() 
	{
		return energyPerRaster;
	}
	
	public double[] getFirstCepstralCoefficients() 
	{
		return firstCepstralCoefficients;
	}
	
	public int getNumberOfRasters() 
	{
		return numberOfRasters;
	}
	
	public int getPaddedRasterLength() {
		
		//Obtenir une longueur qui est une puissance de 2 
		//afin de pouvoir utiliser l'algorithme de TFD rapide
		long length = sampleRate*2/100;
		long p = 1;
		while (p < length) {
			p*=2;
		}
		length = p;
		return (int)length;
		
	}
	
	public Raster[] getRasters() {
		
		return rasters;
		
	}
	
	public Raster[] getTrimmedRasters() {
		
		return trimmedRasters;
		
	}
	
	public double[][] getCepstres() {
		
		return cepstres;
		
	}
	
	
	public double noiseLevel() {
		
		double bruit = 0;
		for (int i=1;i<5;i++) {
			bruit += energyPerRaster[i];
		}
		
		return bruit/5;
	}
	public int[] vocalActivityDetection() {
		int[] result = new int[2];
		boolean startFound = false;
		boolean endFound = false;
		int i = 5;
		int j = numberOfRasters-1;
		double bruit = noiseLevel();
		while (i<j && !startFound) {
			if (energyPerRaster[i]>2*bruit) {
				startFound = true;
			} else i++;
		}
		if (startFound) result[0] = i; else result[0] = 0;
		while (j>i && !endFound) {
			if (2*energyPerRaster[j]<bruit) {
				endFound = true;
			} else j--;
		}
		if (endFound) result[1] = j; else result[1]=numberOfRasters-1;
		return result;
	}
	
	public double[][] getRealCepstres() {
		
		return realCepstres;
	}
	
	public void printEnergyPerRaster() 
	{
		
		for (double truc : energyPerRaster) 
			System.out.println(truc);
	}
	
}

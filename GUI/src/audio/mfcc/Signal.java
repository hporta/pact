package audio.mfcc;

import java.io.File;

import audio.WavFile.WavFile;

public class Signal {

	private long size; // nombre d'échantillons du signal
	private long sampleRate; // fréquence d'échantillonnage
	private double[] samples; // échantillons contenus dans le fichier
	private double[] energyPerRaster; // énergie de chaque trame
	private double[] energyPlot; // énergie non nulles pour les courbes
	private double[] firstCepstralCoefficients; // c(0) de chaque trame
	private Raster[] rasters; // vecteur des trames
	private Raster[] trimmedRasters; // vecteur des trames d'énergie non nulle
	private double[][] cepstres; // vecteur des coefficients cepstraux de chaque trame
	private int numberOfRasters;
	private int paddedRasterLength;
	
	public Signal(String fileName) {
		
		try {
			
			WavFile file = WavFile.openWavFile(new File(fileName));
			
			size = file.getNumFrames();
			
			sampleRate = file.getSampleRate();
			
			numberOfRasters = (int)(size*100/sampleRate);
			//System.out.println(fileName + ": " +numberOfRasters);
			samples = new double[(int)(2*size)];
			file.readFrames(samples, (int)size);
			
			paddedRasterLength = getPaddedRasterLength();
			
			rasters = new Raster[numberOfRasters];
			for (int i=0; i<numberOfRasters; i++) rasters[i] = new Raster(i, this);
			
			energyPerRaster = new double[numberOfRasters];
			for (int i=0; i<numberOfRasters; i++) 
				energyPerRaster[i] = rasters[i].energy();
						
			int p = 0;
			while (p < numberOfRasters && energyPerRaster[p] != 0.) 
			{
				p++;
			}

			trimmedRasters = new Raster[p];
			for (int i=0; i<p; i++) trimmedRasters[i] = rasters[i];
			
			energyPlot = new double[p];
			for (int k=0; k<p; k++) energyPlot[k] = energyPerRaster[k];
			
			cepstres = new double[p][paddedRasterLength];
			for (int i=0; i<p; i++) cepstres[i] = rasters[i].getCepstre();
			
			firstCepstralCoefficients = new double[p];
			for (int i=0; i<p; i++) firstCepstralCoefficients[i] = cepstres[i][0];
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public long getSampleRate() {
		
		return sampleRate;
		
	}
	
	public double[] getSamples() {
		
		return samples;
		
	}
	
	public double[] getEnergyPerRaster() {
		
		return energyPerRaster;
		
	}
	
	public double[] getFirstCepstralCoefficients() {
		
		return firstCepstralCoefficients;
		
	}
	
	public int getNumberOfRasters() {
		
		return numberOfRasters;
		
	}
	
	public int getPaddedRasterLength() {
		
		//Obtenir une longueur qui est une puissance de 2 
		//afin de pouvoir utiliser l'algorithme de TFD rapide
		long length = sampleRate*2/100;
		long p = 1;
		while (p < length) {
			p=2*p;
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

	
	public void printEnergyPerRaster() {
		
		for (double truc : energyPerRaster) System.out.println(truc);
	}
	
}

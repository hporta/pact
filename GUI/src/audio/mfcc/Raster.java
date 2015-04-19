package audio.mfcc;
import java.lang.Math;

import audio.org.apache.commons.math.complex.Complex;
import audio.org.apache.commons.math.transform.FastCosineTransformer;
import audio.org.apache.commons.math.transform.FastFourierTransformer;

public class Raster {

	private long length; // longueur de la trame
	private double[] raster; // échantillons de la trame
	private double[] cepstre; // coefficents cepstraux
	private double[][] melScale; // échelle Mel
	
	public Raster (int number, Signal signal) {
		
		length = signal.getPaddedRasterLength();
		
		raster = new double[(int)length];
		for (int k=0; k<length; k++) raster[k] = signal.getSamples()[(int)(k+number*length/2)];
		
		cepstre = new double[(int)length];
		for (int k=0; k<length; k++) cepstre[k] = 0;
		
		calculateCepstre();
		
	}
	
	public double[] hamming() {
		
		double[] result = new double[(int)length];
		for (int k=0; k<length; k++) result[k] = raster[k]*(0.54-0.46*Math.cos(2*Math.PI*k/(length-1)));
		return result;
		
	}
	
	public Complex[] fourier() {
		
		FastFourierTransformer fft = new FastFourierTransformer();
		Complex[] result = fft.transform(hamming());
		return result;
		
	}
	
	public double energy() {
		
		double sum = 0;
		for (int k=0; k<length; k++) {
			sum = sum + Math.pow(Math.abs(raster[k]), 2);
		}
		return sum/length;
		
	}
	
	public double[] melEnergyLog() {
		
		double[] result = new double[26];
		for (int m=0; m<26; m++) {
			double energy = 0;
			for (int k=0; k<length; k++) energy = energy + melScale[m][k]*Math.pow(Math.abs(raster[k]), 2)/length;
			result[m] = Math.log(energy);
		}
		return result;
	}
	
	public double[] rasterLog() {
		
		double[] x = new double[(int)length+1];
		Complex[] fft = fourier();
		for (int k=0; k<length; k++) x[k] = Math.log10(fft[k].abs());
		x[(int)length] = 0;
		return x;
		
	}

	
	public void calculateCepstre() {
		
		double[] x = rasterLog();
		FastCosineTransformer fct = new FastCosineTransformer();
		double[] result = fct.transform(x);
		for (int i=0;i<13;i++) cepstre[i] = result[i];
	}
	
	
	public double[] getCepstre() {
		
		return cepstre;
		
	}

}

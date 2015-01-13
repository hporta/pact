import java.io.*;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.transform.FastFourierTransformer;

import WavFile.WavFile;
import WavFile.WavFileException;


public class FFTFromSpeechSignal {

	private static File recordingFile;
	private static Complex[] result;
	
	public static void FFT() {
		
		AudioRecorder audioRecorder = new AudioRecorder();
		audioRecorder.setFile(recordingFile);
		audioRecorder.record();
		try {
			WavFile wavFile = WavFile.openWavFile(recordingFile);
			long numFrames = wavFile.getNumFrames();
			double[] samples = new double[(int)(2*numFrames)];
			wavFile.readFrames(samples, (int)numFrames);
			FastFourierTransformer fft = new FastFourierTransformer();
			result = fft.transform(samples);
		} catch (WavFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

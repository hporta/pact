package fichiers;
import java.io.File;

public class TestRecorder {
	
		public static void main(String[] args) {
			
			final AudioRecorder recorder = new AudioRecorder();
			
			Thread stopper = new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(AudioRecorder.RECORDTIME);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					recorder.finish();
				}
			});
			
			stopper.start();
		
			File audio = new File("src/data/silence.wav");
			recorder.setFile(audio);
			recorder.record();

		}

	}
	


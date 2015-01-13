package audio;
import java.io.*;

import javax.sound.sampled.*;

public class AudioPlayer implements Runnable {

	private SourceDataLine line;
	private File file;
	private AudioInputStream audioInputStream;	
    private AudioFormat audioFormat;
	private boolean stop=false;	

	public void stop() {
		stop=true;
	}

    public void init(){
        
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
      
        audioFormat = audioInputStream.getFormat();
        //System.out.println(audioFormat);
            
        DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                audioFormat);


        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
           
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        }
    } 
    
	public void run() {
        
        stop = false;

        try {
            line.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
  
        }

        line.start();

		try {
			byte bytes[] = new byte[1024];
			int bytesRead=0;			
			while (((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1)
					&& !stop) {
				
				line.write(bytes, 0, bytesRead);
			}
		} catch (IOException io) {
			io.printStackTrace();
			return;
		}

		line.close();
	}	

	public void setFile(File file) {
		this.file = file;
       
	}

	public SourceDataLine getLine() {
		return line;
	}	
	

}


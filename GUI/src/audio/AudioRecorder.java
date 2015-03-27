package audio;
import java.io.*;
import javax.sound.sampled.*;

public class AudioRecorder {

    private TargetDataLine line;
    private File file;
    private ByteArrayOutputStream outputStream;
    private AudioFormat audioFormat;
    private static final AudioFileFormat.Type targetType = AudioFileFormat.Type.WAVE;
    public static final long RECORDTIME = 2000;

    public void record() {

        audioFormat = new AudioFormat(16000, 16, 2, true, true);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

        if (!AudioSystem.isLineSupported(info)) {
            System.err.println("Audio Format specified is not supported");
            return;
        }

        line = null;
        AudioInputStream audioInputStream = null;
        try {
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();
            audioInputStream = new AudioInputStream(line);
            AudioSystem.write(audioInputStream, targetType, file);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } //finally {
        	//try {
            	//line.stop();
            	//line.close();
                //audioInputStream.close();
            //} catch (IOException e) {}
        //}
    }

    public void finish() {
    	line.stop();
    	line.close();
    	System.out.println("enregistrement terminé");
    }
    
    public void setFile(File file) {
        this.file = file;
    }

    public TargetDataLine getLine() {
        return line;
    }

}

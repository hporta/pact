package fichiers;
import java.io.File;


public class TestPlayer {

	public static void main(String[] args) {
		
		AudioPlayer player = new AudioPlayer();
		File audio = new File("src/data/c_chocolatchaud.wav");
		player.setFile(audio);
		player.init();
		player.run();
	}

}

import java.io.File;


public class Test {

	public static void main(String[] args) {
		
		AudioPlayer player = new AudioPlayer();
		File audio = new File("src/data/GROCK01.WAV");
		player.setFile(audio);
		player.init();
		player.run();
	}

}

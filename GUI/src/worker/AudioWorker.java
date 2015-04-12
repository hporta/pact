package worker;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class AudioWorker extends Thread implements Observer
{
	private AudioList tasks;
	
	public AudioWorker(AudioList tasks)
	{
		tasks.addObserver(this);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) 
	{
		File newFile = (File) arg0;
		// TODO Auto-generated method stub
		
	}
}

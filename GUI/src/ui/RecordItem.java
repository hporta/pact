package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import audio.AudioPlayer;
import audio.AudioRecorder;

public class RecordItem extends JPanel implements ActionListener
{
	private AudioPlayer player;
	private AudioRecorder recorder;
	private String pathName;
	
	private JProgressBar bar;
	private JButton record;
	private JButton play;
	private JButton delete;
	
	private final String RECORD = "RECORD";
	private final String PLAY = "PLAY";	
	private final String DELETE = "DELETE";	

	RecordItem(String pathName)
	{
		this.pathName = pathName;
		
		setLayout(new FlowLayout());
		bar = new JProgressBar();
		record = new JButton("Enregistrer");
		record.setActionCommand(RECORD);
		record.addActionListener(this);
		
		play = new JButton("Ecouter");
		play.setActionCommand(PLAY);
		play.addActionListener(this);
		
		delete = new JButton("Supprimer");
		delete.setActionCommand(DELETE);
		delete.addActionListener(this);
		
		add(bar);
		add(record);
		add(play);
		add(delete);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Delete this file
		if(e.getActionCommand().equals(DELETE))
		{

		}
		
		//Play the file
		else if(e.getActionCommand().equals(PLAY))
		{
			
			//Player
			player = new AudioPlayer();
			player.setFile(new File(pathName));
			player.init();

			
			Thread thread = new Thread()
			{
				@Override
				public void run()
				{
					player.run();
				}
			};
			thread.start();
			
			try 
			{
				Thread.sleep(2000);
			}
			catch(Exception exce)
			{
				exce.printStackTrace();
			}
			
			player.stop();
		}
		
		//Record the file
		else if(e.getActionCommand().equals(RECORD))
		{
			//Recorder
			recorder = new AudioRecorder();
			recorder.setFile(new File(pathName));
			
			Thread thread = new Thread()
			{
				@Override
				public void run()
				{
					recorder.record();
				}
			};
			thread.start();
			
			try 
			{
				Thread.sleep(2000);
			}
			catch(Exception exce)
			{
				exce.printStackTrace();
			}
			
			recorder.finish();
		}
		
	}
	
	
}

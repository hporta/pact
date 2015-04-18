package communication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import worker.TaskList;

/**
 * Sert pour le transfert de fichier
 */
public class ReceptionThread implements Runnable
{
	//Socket
	private ServerSocket server;

	private final int port;
	private final String repository;
	private final String extension;
	private TaskList taskList;
	
	public ReceptionThread(int port, String repository, String extension, TaskList taskList)
	{
		this.port = port;
		this.repository = repository;
		this.extension = extension;
		this.taskList = taskList; 
		
		cleanRepository();
		
		try
		{
			server = new ServerSocket(port);
		}
		
		catch(Exception e)
		{
			System.err.println("Erreur lors de l'initialisation du serveur pour le port : " + port);
		}
	}
	
	//Waiting for file Transfert from remote device
	public void run()
	{
		while(true)
			waitForFile();
	}
	
	public void waitForFile()
	{
		try 
		{
			//Le client accepte la connexion
			Socket client = server.accept();
			System.out.println("Client connecté sur le port : " + port);
			
			//Recherche d'un fichier disponible
			String destinationPath = findAvailablePathName();	
			
			//Fonction de transfert
			Transfert.transfert(client.getInputStream(), new FileOutputStream(new File(destinationPath)), true);
			
			//Fermeture des sockets
			client.close();
			System.out.println("Fin de connection sur le port : " + port);
			
			//Ajout du fichier dans la liste de traitement
			taskList.add(destinationPath);
		}
		
		catch (IOException | InterruptedException e) 
		{
			System.err.println("Erreur pendant la connection avec le client sur le port : " + port);
		}
	}
	
	public void cleanRepository()
	{
		File directory = new File(repository);
		for(File file : directory.listFiles())
			file.delete();
	}
	
	public String findAvailablePathName()
	{
		String destinationPath = repository + "file";
		File destination;
		
		do{
			destinationPath  = repository + "file" + (int) Math.random()*100 + extension;
			destination  = new File(destinationPath);
		} while(destination.exists());
		
		return destinationPath;
	}
}

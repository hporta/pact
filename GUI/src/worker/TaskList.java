package worker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskList 
{
	private BlockingQueue<String> queue;
	private static final int MAX_TASKS = 20; 
	
	public TaskList()
	{
		this.queue = new ArrayBlockingQueue<String>(MAX_TASKS);
	}
	
	public void add(String pathName)
		throws InterruptedException 
		{
			queue.put(pathName);
		}
	
	public String next()
		throws InterruptedException
		{
			return queue.take();
		}
}

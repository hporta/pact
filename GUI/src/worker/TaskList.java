package worker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TaskList 
{
	private BlockingQueue<String> queue;
	private static final int MAX_TASKS = 20; 
	
	public TaskList()
	{
		this.queue = new ArrayBlockingQueue<String>(MAX_TASKS);
	}
	
	public boolean add(String pathName)
		throws InterruptedException 
		{
			return queue.offer(pathName, 200, TimeUnit.MILLISECONDS);
		}
	
	public String next()
		throws InterruptedException
		{
			return queue.poll(200, TimeUnit.MILLISECONDS);
		}
}

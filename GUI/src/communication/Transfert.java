package communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Transfert 
{
	public static void transfert(InputStream in, OutputStream out, boolean closeOnExit)
	throws IOException
	{
		byte buf[] = new byte[1000000];
		
		int n;
		int i = 0;
		while((n=in.read(buf)) != -1)
		{
			System.out.println("Paquet n°" + i);
			i++;
			out.write(buf,0,n);
		}
		
		if(closeOnExit)
		{
			in.close();
			out.close();
		}
	}
}

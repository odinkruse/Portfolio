import java.util.concurrent.Semaphore;
import java.io.*;
public class MyThread extends Thread
{ 
FileInputStream filein;
FileOutputStream fileout;
int thread;
private Semaphore writeLock = new Semaphore(1);
   public MyThread(int in_thread)
   {
	   thread = in_thread;
	   try {
		filein = new FileInputStream("in.txt");
		fileout = new FileOutputStream("out.txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public void run()
   {
	   int c = 0;

		do{
			try {
				c = filein.read();
				writeLock.acquire();
				//System.out.println("printed by "+thread);
				fileout.write(c);
			}
			catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				writeLock.release();
			}
		}while(c != -1);
   }
}

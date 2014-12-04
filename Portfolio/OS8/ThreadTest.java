
public class ThreadTest
{
   public static void main(String [] args)
   {
	     MyThread t1 = new MyThread(1);
	     MyThread t2 = new MyThread(2);
	     t1.start();
	     t2.start();
	} 
}
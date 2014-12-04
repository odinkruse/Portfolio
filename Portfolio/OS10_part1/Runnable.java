import java.io.FileWriter;
import java.io.IOException;

public class Runnable {

	public static void main(String[] args) {
	Partition test;
	try {
		FileWriter writecsv = new FileWriter("csvout.csv");
		writecsv.write('\n');
	} catch (IOException e) {
		e.printStackTrace();
	}
	for(int i = 150; i<300; i+=2)
	{
		long time1 = 0;
		long time2 = 0;
		for(int j = 0; j<10000;j++)
		{
		 test = new Partition(i,i*2);
		 time1+=test.time1out();
		 time2+=test.time2out();
		}
		csvout(i, (time1/10000), (time2/10000));
	}
	}
	private static void csvout(int i, long time1, long time2)
	{
		try {
			FileWriter writecsv = new FileWriter("csvout.csv", true);
			writecsv.append(i+", "+time1+", "+i+", "+time2+'\n');
			writecsv.flush();
			writecsv.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
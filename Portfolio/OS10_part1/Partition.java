import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;


public class Partition {
	Random rgen = new Random();
	long current, elapsed, elapsed2;
	private int[] nonthreadedArr, threadedArr;
	private int[] currentArr, lowarr, upparr, Q1, Q2, Q3, Q4;
	
	public Partition(int arrsize, int seed)
	{
		generate(arrsize, seed);
		current = System.currentTimeMillis();
		Quicksort nonthreaded = new Quicksort(nonthreadedArr);
		elapsed = (new Date()).getTime() - current;
		setup(threadedArr);
		
	}
	public void setup(int[] values)

	{
		currentArr = values;
		current = System.currentTimeMillis();
		partitionArr(currentArr, 0, currentArr.length-1, (currentArr.length/2));
		int[] firsthalf = lowarr;
		int[] secondhalf = upparr;
		partitionArr(firsthalf, 0, firsthalf.length-1, (firsthalf.length/2));
		Q1 = lowarr;
		Q2 = upparr;
		partitionArr(secondhalf, 0, secondhalf.length-1, (secondhalf.length/2));
		Q3 = lowarr;
		Q4 = upparr;
		sendout();
	}
	public void generate(int length, int seed)
	{	int randint;
		nonthreadedArr = new int[length];
		threadedArr = new int[length];
		for(int i = 0; i<length; i++)
		{	randint = rgen.nextInt(seed);
			nonthreadedArr[i] = randint+1;
			threadedArr[i] = randint+1;
		}
	}
	private void partitionArr(int[] inArr,int left, int right, int in_pivotindex)
	{
		if(inArr.length == 0)
			return;
		int pivotvalue = inArr[in_pivotindex];
		inArr = exchange(inArr, in_pivotindex, right);
		int storeindex = left;
		for(int i = left;i < right; i++)
		{
			if(inArr[i]<= pivotvalue)
			{
				inArr = exchange(inArr, i, storeindex);
				storeindex++;
			}
		}
		inArr = exchange(inArr, storeindex, right);
		lowarr= new int[storeindex];
		upparr = new int[inArr.length-storeindex];

		for(int i = 0; i < storeindex; i++)
		{

			lowarr[i] = inArr[i];
		}

		for(int i = storeindex, j = 0; i < inArr.length; j++, i++)
		{

			upparr[j] = inArr[i];
		}
	}
	private int[] exchange(int[] inArr, int i, int j) {
		int temp = inArr[i];
		inArr[i] = inArr[j];
		inArr[j] = temp;
		return inArr;
		
	}

	public void sendout()
	{
		ThreadSort firstQ = new ThreadSort(Q1, 1);
		ThreadSort secondQ = new ThreadSort(Q2,2);
		ThreadSort thirdQ = new ThreadSort(Q3,3);
		ThreadSort fourthQ = new ThreadSort(Q4,4);
		
		try {
			firstQ.start();
			firstQ.join();
			secondQ.start();
			secondQ.join();
			thirdQ.start();
			thirdQ.join();
			fourthQ.start();
			fourthQ.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		do{}while(firstQ.isAlive()&&secondQ.isAlive()&&thirdQ.isAlive()&&fourthQ.isAlive());
		elapsed2 = (new Date()).getTime() - current;
	}
	public void print(int[] inarr) 
	{
		for(int i = 0;i<inarr.length;i++)
		{
			System.out.print(inarr[i]+" ");
		}
	}
	public long time1out()
	{
		return elapsed;
	}
	public long time2out()
	{
		return elapsed2;
	}

}

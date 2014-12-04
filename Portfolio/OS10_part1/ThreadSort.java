import java.io.IOException;
import java.io.FileWriter;



public class ThreadSort extends Thread{
	private int threadno;
	private int[] numbers;
	private int number;

	public ThreadSort(int[] values, int in_threadno)
	{
		threadno = in_threadno;
		numbers = values;

	}
	public void run() {
		


		if (numbers== null || numbers.length ==0) {
			return;
		}
			number = numbers.length;
			quicksort(0, number -1);
	}
	private void quicksort( int low, int high)
	{
		int i = low, j = high;
		int pivot = numbers[low+(high-low)/2];
		while(i<=j) {
			while (numbers[i] < pivot) {
					i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}
			if(i<=j) {
				exchange(i,j);
				i++;
				j--;
			} 
			if(low<j)
				quicksort(low, j);
			if(i < high)
				quicksort(i, high);
		}
	}
	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}

  


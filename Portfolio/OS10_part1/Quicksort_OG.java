
public class Quicksort_OG {
	boolean setup;
	boolean flag = false;
	private int[] numbers;
	private int number;

	public void sort(int[] values, boolean in_setup) {//takes the array and a setup boolean to check if we need to partition
		if (values == null || values.length ==0) {//returns nothing if there is nothing in the array
			return;
		}
		setup = in_setup;//sets global setup boolean to the input setup boolean
		this.numbers = values;//sets global array equal to the input array
		number = values.length;//sets the length of the array input to
		System.out.println("array length " + number+" midpoint  "+number/2);//prints the length of the array and the midpoint place of the array
		partitionsort(0, number -1);//calls the partition method to split the array into greater and smaller halves
		
	}
	private void partitionsort( int low, int high)
	{
		int i = low, j = high;
		int pivot = numbers[low+(high-low)/2];
		int middle = number/2;
		if(setup)// if there is a setup needed (to split into two arrays) then this if statement takes the array through the split process
		{
			check_partition(middle);
			if(flag)
			{
				setup = false;
				split(middle);
			}
		}///////// everything below here in this method is just quicksort stuff to get the array in the position it needs to be in for partitioning/////////
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
				partitionsort(low, j);
			if(i < high)
				partitionsort(i, high);
		}
	}
	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	private void check_partition(int middle)// method uses nested for loops to check if all items in the bottom half are smaller than top half
	{
		for(int lower = 0; lower < middle; lower++)
		{
			for(int upper = number-1; upper >= middle; upper-- )
			{
				if(numbers[lower]<=numbers[upper])
				{
					flag = true;
				}
				else
					flag = false;
				if(!flag)
				{
					break;
				}
			}
			if(!flag)
			{
				
				break;
			}
		}
	}
	public void split(int middle)//this method just uses for loops to split the original array into 2
	{
		int[] lowarr = new int[middle];
		int[] upparr = new int[numbers.length-middle];
		System.out.println("Lower ");
		for(int i = 0; i < middle; i++)
		{
			System.out.print(numbers[i]+" ");
			lowarr[i] = numbers[i];
		}
		System.out.println();
		System.out.println("Upper ");
		for(int i = middle, j = 0; i < numbers.length; j++, i++)
		{
			System.out.print(numbers[i]+" "); //prints the upper half of the original array
			upparr[j] = numbers[i];
		}
		ThreadSort firsthalf = new ThreadSort(lowarr, 1);//self explanatory
		ThreadSort secondhalf = new ThreadSort(upparr,2);
		firsthalf.start();
		System.out.println();
		secondhalf.start();
	}

}


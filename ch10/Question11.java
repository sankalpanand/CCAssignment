package Chapter5;

import java.util.Arrays;

public class Question11 
{
	public static void main(String[] args) 
	{
		int[] array = { 5, 3, 1, 2, 3 };
		sort(array);
	}

	// The idea is to sort the array and swap adjacent elements. 
	// Do this for every alternating number.
	public static void sort(int[] array) 
	{
		Arrays.sort(array);
		int i=1;
		
		while (i < array.length) 
		{			
			swap(array, i - 1, i);
			i = i + 2;
		}
	}
	
	public static void swap(int[] array, int left, int right) 
	{
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}

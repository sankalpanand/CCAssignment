package Chapter5;

public class Question04 {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
		Listy obj = new Listy(array);
		System.out.println(search(obj, 10));
		System.out.println(search(obj, 99));
	}

	/*
	 * Since, we don't have an access to the size, we somehow get the high and low value for binary seaech.
	 * We will start a runner, it will get multiplied by 2 every iteration and compare the value with element at runner index.
	 * Whenever the loop breaks, that will be the upper bound. After this, it is a plain binary search.
	 * */
	public static int search(Listy obj, int value) 
	{
		int index = 1;
		while (obj.elementAt(index) != -1 && obj.elementAt(index) < value) 
		{
			index *= 2;
		}
		
		int high = index;
		int low = index/2;
				
		return Search(obj, value, low, high);
	}
	
	/*
	 * This method searches the element in the array using binary search method.
	 * */
	public static int Search(Listy list, int value, int low, int high) 
	{
		int mid;
		
		while (low <= high) 
		{
			mid = (low + high) / 2;
			int middle = list.elementAt(mid);
			
			if (middle > value || middle == -1) 
			{
				high = mid - 1;
			} 
			else if (middle < value) 
			{
				low = mid + 1;
			} 
			else 
			{
				return mid;
			}
		}
		
		// Element not found
		return -1;		
	}
}

class Listy 
{
	int[] array;
	
	public Listy(int[] arr) 
	{
		this.array = arr;
	}
	
	public int elementAt(int index) 
	{
		if (index >= array.length) 
		{
			return -1;
		}
		
		return array[index];
	}
}

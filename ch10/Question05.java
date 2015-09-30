package Chapter5;

public class Question05 {

	public static void main(String[] args) 
	{
		String[] stringList = {"at", "", "ball","", "", "",  "car","", "", "",  "dad","", "", "", };
		int result = search(stringList, "car");
		System.out.println(result);
	}

	/*
	 * 
	 * */


	public static int search(String[] strings, String str) 
	{
		if (strings == null || str == null || str.isEmpty()) 
		{
			return -1;
		}

		return searchR(strings, str, 0, strings.length - 1);
	}

	public static int searchR(String[] strings, String str, int first, int last) 
	{
		if (first > last) 
		{
			return -1;
		}

		// Since the array is sorted, Calculate mid
		int mid = (last + first) / 2;

		/* If mid is empty, find closest non-empty string. */
		if (strings[mid].isEmpty()) 
		{ 
			int left = mid - 1;
			int right = mid + 1;

			// This loop will continue until first non null value is met while moving away from MID on both sides
			// OR
			// both ends are reached and still no non null value was found 
			while (true) 
			{
				// While spreading pointers towards left and right, if either boundary is met, return NOT FOUND (-1)
				if (left < first && right > last) 
				{
					return -1;
				} 

				// If right has not reached till last AND right has some value 
				else if (right <= last && !strings[right].isEmpty()) 
				{
					// Make it as the pointer and break the loop
					mid = right;
					break;
				} 

				// If left has not reached till first AND left has some value
				else if (left >= first && !strings[left].isEmpty()) 
				{
					// Make it as the pointer and break the loop
					mid = left;
					break;
				}

				right++;
				left--;
			}
		}
		// After coming out of this loop, we will have a new mid which will be on either side of the blank mid.

		// If found, return the index
		if (str.equals(strings[mid])) 
		{
			return mid;
		} 

		// a compare (b) => -1
		// b compare (a) => +1
		// If the middle string is alphabetically lesser than the given, then you need to discard left and look in right
		else if (strings[mid].compareTo(str) < 0) 
		{
			return searchR(strings, str, mid + 1, last);
		} 

		// If the middle string is alphabetically greater than the given, then you need to discard right and look in left
		else 
		{
			return searchR(strings, str, first, mid - 1);
		}
	}
}



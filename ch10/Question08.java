package Chapter5;

import java.io.BufferedReader;
import java.io.FileReader;

public class Question08 {

	/*
	 * The max size of integers is 2^32. So, the total number of unique integers can be 2^32 which is approx 4 Billion.
	 * We can declare a bit array of 4 Billion size. We will initialize them with 0.
	 * Scan through the file, keep setting the particular bit when you see that number. 
	 * Once you are done, scan the bit aray. Return the first number which is still 0. 
	 * */

	public static int Find()
	{
		boolean[] status = new boolean[Integer.MAX_VALUE];

		String inputFile = "path\to\file";
		BufferedReader br = null;
		String line = "";

		try 
		{

			br = new BufferedReader(new FileReader(inputFile));

			while ((line = br.readLine()) != null) 
			{
				int num = Integer.parseInt(line);
				status[num] = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		// Get the first position with bit set as 0
		int index = 0;
		for(int i=0; i<Integer.MAX_VALUE; i++)
		{
			if(!status[i])
			{
				index = i;
				break;
			}				
		}

		// Now read the file again till the index and output the number
		int count=0;
		int result = 0;
		try 
		{
			br = new BufferedReader(new FileReader(inputFile));

			while ((line = br.readLine()) != null) 
			{
				if(count == index)
				{
					result = Integer.parseInt(line);
					break;
				}				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return result;

	}

}

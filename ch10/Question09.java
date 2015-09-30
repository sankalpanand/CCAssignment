package Chapter5;

public class Question09 
{

	/*
	 * 
		00  01  02  03  04  05  06  07  08  
		10  11  12  13  14  15  16  17  18  
		20  21  22  23  24  25  26  27  28  
		30  31  32  33  34  35  36  37  38  
		40  41  42  43  44  45  46  47  48  
		50  51  52  53  54  55  56  57  58  
		60  61  62  63  64  65  66  67  68  
		70  71  72  73  74  75  76  77  78  
		80  81  82  83  84  85  86  87  88  

	 * */

	// Start from Top righht se chalo...
	// If mat[i][j] is larger, then move left
	// If mat[i][j] is smaller, then move down
	public static int search(int[][] mat, int size, int search) 
	{
		// set indexes for top right element
		int i = 0, j = size - 1;

		// Decrease j by 1 and increase i by 1. 
		// So check for their limits
		while (i < size && j >= 0) 
		{
			if (mat[i][j] == search) 
			{
				System.out.println("Found at " + i + "," + j);
				return 1;
			}

			if (mat[i][j] > search)
				j--;

			else
				// if mat[i][j] < x
				i++;
		}

		return 0;
	}
}

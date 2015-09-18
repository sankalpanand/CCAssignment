package Chapter1;
public class Solution08 {

	public static void main(String[] args) 
	{
		Solution08 obj = new Solution08();

		int[][] mat = {
				{0,0,0,5},
				{4,3,1,4},
				{0,1,1,4},
				{1,2,1,3},
				{0,0,1,1}
		};
		
		obj.print(mat);
		obj.ZeroMatrix(mat);
		System.out.println();
		obj.print(mat);
	}

	// The idea is to maintain two separate arrays which will tell 
	// whether or not that row/col contains a zero.
	// While printing it, we will see status from these arrays	
	public void ZeroMatrix(int[][] matrix) 
	{
		int rows = matrix.length;
		int cols = matrix[0].length;

		boolean[] rowStatus = new boolean[rows];
		boolean[] colStatus = new boolean[cols];

		// Checking zero values in the array and setting boolean arrays
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				if(matrix[i][j] == 0)
				{
					rowStatus[i] = true;
					colStatus[j] = true;
				}
			}
		}
		
		// Setting zeros in the array
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				if(rowStatus[i] == true || colStatus[j] == true)
				{
					matrix[i][j] = 0;
				}
			}
		}
	}

	// For display
	public void print(int[][] matrix)
	{
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

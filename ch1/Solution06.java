package Chapter1;
public class Solution06 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Solution06 obj = new Solution06();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		obj.print(matrix);
		obj.rotate(matrix);
		System.out.println();
		obj.print(matrix);
	}

	/* The idea is to transpose a matrix, 
	 * then flip the matrix horizontally to rotate clockwise and vertically to rotate counter clockwise.
	 * 
 	1  2  3             
	4  5  6
	7  8  9

	[Transpose] => matrix[i][j] = matrix[j][i];

	1  4  7
	2  5  8
	3  6  9

	[Flip horizontally] => matrix[i][j] = matrix[i][matrix.length-1-j];

	7  4  1
	8  5  2
	9  6  3
	 * 
	 * */

	// Assumption - the matrix is an integer matrix
	public void rotate(int[][] matrix) 
	{
		for(int i = 0; i<matrix.length; i++)
		{
			for(int j = i; j<matrix[0].length; j++)
			{
				swap(matrix, i,j,j,i);                
			}
		}

		for(int i =0 ; i<matrix.length; i++)
		{
			for(int j = 0; j<matrix.length/2; j++)
			{
				swap(matrix, i, j, i, matrix.length-1-j);                               
			}
		}
	}

	public void swap(int[][] matrix, int x1, int y1, int x2, int y2)
	{
		int temp = matrix[x1][y1];
		matrix[x1][y1] = matrix[x2][y2];
		matrix[x2][y2] = temp;		
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

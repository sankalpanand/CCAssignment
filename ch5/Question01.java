package Chapter5_1;


public class Question01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1024; // 10000000000
		int M = 19; // 10011
		int res = insertion(N, M, 2, 6);
		System.out.println(Integer.toBinaryString(res));

	}



	static int insertion(int n, int m, int i, int j) 
	{
		// Create left half of the mask
		int allOnes = ~0;
		int leftHalf = allOnes << (j + 1); // We use j here
		
		// Create right half of the mask.
		// 1<<i will give the multiple of 2. Minus 1 will give me all ones in the last i bits.
		int rightHalf = (1 << i) - 1; // We use i here
		
		// Create the mask
		int mask = leftHalf | rightHalf;

		// Clear the bits in M from i to j
		int clearedN = n & mask;

		// Shift M so that it is aligned
		int shiftedM = m << i;

		// Merge M and N
		int res = clearedN | shiftedM;

		// clear bit & set bit
		return res;
	}



}

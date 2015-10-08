package Chapter5_1;


public class Question07 {

	public static void main(String[] args) 
	{
		System.out.println(swapEvenOddBits(123));
	}


	public static int swapEvenOddBits(int n) 
	{
		int oddMask = 0xaaaaaaaa;
		int evenMask = 0x55555555;
		
		int oddShiftedByOne = (n & oddMask) >> 1;
		int evenShiftedByOne = (n & evenMask) << 1;
		
		return oddShiftedByOne | evenShiftedByOne;
	}

}

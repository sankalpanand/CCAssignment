package Chapter5_1;

public class Question06 {

	public static void main(String[] args) 
	{
		System.out.println(calculateDist(29,15));
	}
	
	public static int calculateDist(int a, int b)
	{
		int temp = a ^ b;
		int count = 0;
		
		for(int i=temp; i!=0; i = i >> 1)
		{
			count = count + (i&1);
		}
		
		return count;
	}
	
}



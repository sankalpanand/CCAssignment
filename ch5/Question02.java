package Chapter5_1;
import java.util.*;

public class Question02 {

	public static void main(String[] args) 
	{
		System.out.println(binaryToString(0.75));
	}


	public static String binaryToString(double n) 
	{
		// If the number is invalid, return error message
		if (n <= 0 || n >= 1) 
			return "ERROR";

		StringBuffer sb = new StringBuffer("0.");

		while (n > 0) 
		{
			n = n * 2;
			
			// It means, the number to the right of the decimal was a 1.
			if (n >= 1) 
			{ 
				sb.append("1");
				
				// Update the number by removing the 1 from the left of the decimal.
				n = n - 1;
			}
			
			// It means the number to the right of the decimal was a 0.
			else 
			{
				sb.append("0");
			}

			if (sb.length() > 32) 
				return "ERROR";
		}

		return 
			sb.toString();
	}

}

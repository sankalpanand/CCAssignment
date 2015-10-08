package Chapter6;

import java.util.Random;

public class Question07 {

	/*
	 
	 To follow the laws, each family will have either 0 or multiple Boys followed by girls. 
	 For example, G, BG, BBG, BBBG, and so on...
	 
	 Let's deduce the gender ration mathematically-
	 Sequence- G		#Boys- 0	Probability- 1/2	#Boys * Probability- 0
	 Sequence- BG		#Boys- 1	Probability- 1/4	#Boys * Probability- 1/4
	 Sequence- BBG		#Boys- 2	Probability- 1/8	#Boys * Probability- 2/8
	 Sequence- BBBG		#Boys- 3	Probability- 1/16	#Boys * Probability- 3/16
	 Sequence- BBBBG	#Boys- 4	Probability- 1/32	#Boys * Probability- 4/32
	 Sequence- BBBBBG	#Boys- 5	Probability- 1/64	#Boys * Probability- 5/64
	 Sequence- BBBBBBG	#Boys- 6	Probability- 1/128	#Boys * Probability- 6/128
	 
	 Therefore, it is the SUM(i/2^i) where i = 0 to n
	 If we plug n=6 here, we get 120/128.
	 As we increase n, the ratio will move closer to 1.
	 
	 Therefore, gender ratio will be close to 1 : 1
	 
	 
	 
	 * */
	
	public static void main(String[] args) 
	{
		double ratio = RandomProductionInNFamilies(10000);
		System.out.println(ratio);
	}
	
	public static double RandomProductionInNFamilies(int n) 
	{
		int noOfBoys = 0;
		int noOfGirls = 0;
		
		// Count the boys and girls for each of the n families
		for (int i = 0; i < n; i++) 
		{
			// Get the sequence from a random family
			int[] genders = RandomProductionInOneFalimy();
			
			// Update city count by adding G and B from this family
			noOfGirls = noOfGirls + genders[0];
			noOfBoys = noOfBoys + genders[1];
		}
		return noOfGirls / (double) (noOfBoys + noOfGirls); 
	}
	
	public static int[] RandomProductionInOneFalimy() 
	{
		Random random = new Random();
		int noOfBoys = 0;
		int noOfGirls = 0;
		
		// As long as girls are not taking birth, keep on producing children.
		while (noOfGirls == 0) 
		{ 
			if (random.nextBoolean()) 
			{ 
				noOfGirls = noOfGirls + 1;
			} 
			else 
			{ 
				noOfBoys = noOfBoys + 1;
			}
		}
		
		int[] genders = {noOfGirls, noOfBoys};
		return genders;
	}
	
	
	
	

}

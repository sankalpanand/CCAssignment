package Chapter4;

import java.util.Random;

public class Solution11 
{
	public static void main(String[] args) 
	{
		// int[] counts = new int[10];
		Tree tree = new Tree();
		
		int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
		for (int node : array) 
		{
			tree.BuildTree(node);
		}
		
		// Generate a random number
		Random random = new Random();
		int i = random.nextInt(tree.root.size);
		
		// Call the root's method to get the random node
		System.out.println(tree.root.getIthNode(i).data);	
	}
}
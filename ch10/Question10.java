package Chapter5;


public class Question10 
{

	private static RankNode root = null;	

	// This method inputs the element in the data structure. 
	public static void track(int number) 
	{
		if (root == null) 
			root = new RankNode(number);
		
		else 
			root.insert(number);
	}

	// This method gets the rank of the input number
	public static int getRankOfNumber(int number) 
	{
		return root.getRank(number);
	}
}

class RankNode 
{
	public int left_size = 0;
	public RankNode left;
	public RankNode right;
	public int data = 0;

	public RankNode(int d) 
	{
		data = d;
	}

	public void insert(int d) 
	{
		// If d is smaller than the root
		if (d <= data) 
		{
			// If LST exists, recurse for insert in LST
			if (left != null) 
			{
				left.insert(d);
			} 

			// LST does not exists, create a new node and call it LST
			else 
			{
				left = new RankNode(d);
			}

			// Increase the size whenever there has to be a node inserted in the LST
			left_size++;
		}

		// If d is greater than the root
		else 
		{
			if (right != null) 
			{
				right.insert(d);
			} 
			else 
			{
				right = new RankNode(d);
			}

			// No need to count
		}
	}

	public int getRank(int d) 
	{
		if (d == data) 
		{
			return left_size;
		} 

		// d lies in LST
		else if (d < data) 
		{
			if (left == null) 
			{
				return -1;
			} 
			else 
			{
				return left.getRank(d);
			}
		} 

		// d lies in RST
		else 
		{
			int right_rank = right == null ? -1 : right.getRank(d);

			// If there is no RST, return -1
			if (right_rank == -1) 
			{
				return -1;
			} 

			// If there is RST, rank should be left_size + root + right_rank
			else 
			{
				return left_size + 1 + right_rank;
			}
		}
	}
}

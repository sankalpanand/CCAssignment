package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution03 
{
	public static void main(String[] args) 
	{
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = Solution02.createMinimalBST(array, 0, array.length - 1);
		levelOrder(root);
	}


	// The idea is to take size of a queue before enqueuing new elements. 
    // Any element present in the queue before inserting left and right child is on the same level.
	public static List<List<Integer>> levelOrder(TreeNode root) 
	{
		List<List<Integer>> tree = new ArrayList<List<Integer>>();
        if(root == null) return tree;
        
        List<Integer> level;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(queue.size() != 0)
        {
            level = new LinkedList<Integer>();
            int size = queue.size();
            
            // We can't use while here because we will be adding children to the queue
            for(int i = 0; i < size; i++)
            {
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                level.add(queue.poll().data);
            }
            
            tree.add(level);
        }
        
        return tree;        
    } 
}
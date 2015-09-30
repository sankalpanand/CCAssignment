package Chapter5;
import java.util.*;

public class Question02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"tea","and","ate","eat","den"};
		List<List<String>> result = groupAnagrams(input);
		for (List<String> list : result) 
		{
			System.out.println(Arrays.asList(list));
		}
		
	}
	
	/*
	 * I am maintaining a hash map in which I am storing the anagram with chars in sorted order
	 * Its value will be all the anagrams with the same characters as the key 
	 * */
	public static List<List<String>> groupAnagrams(String[] strs) 
	{
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		// Iterate over each string
		for (String string : strs) 
		{
			// Convert each string to char array. It will make it easier to sort.
			char[] c = string.toCharArray();
			Arrays.sort(c);
			
			// Form a new string using that char array
			String key = new String(c);
			
			// Check if this anagram already exists in the map or not?
			// If yes, then add the current word to its value
			if (map.containsKey(key))
				map.get(key).add(string);
			
			// If not, then create a new list and add this word in the list and add it to map
			else 
			{
				List<String> temp = new LinkedList<String>();
				temp.add(string);
				map.put(key, temp);
			}
		}

		// Now, sort all the anagrams in the list
		List<List<String>> ans = new LinkedList<List<String>>();
		for (String key : map.keySet()) 
		{
			List<String> temp = new LinkedList<String>(map.get(key));
			Collections.sort(temp);
			ans.add(temp);
		}
		
		return ans;
	}

}

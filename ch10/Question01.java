package Chapter5;

import java.util.Arrays;

public class Question01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {1,3,5,7,0,0,0,0};
		int nums2[] = {2,4,6,8};
		System.out.println(Arrays.toString(merge(nums1, 4, nums2, 4)));		

	}
	
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) 
	{
		// Calculate individual and total lengths of the arrays
        int len1 = m-1;
        int len2 = n-1;
        int totalLen = m + n -1;
        
        // Start comparing both the arrays from their ends, whichever number is greater, copy it at the end 
        while(len1 >= 0 && len2 >= 0)
        {
            if(nums1[len1] >= nums2[len2])
                nums1[totalLen--] = nums1[len1--];
            
            else
                nums1[totalLen--] = nums2[len2--];
        }
        
        // The above while loop will terminate when smaller array will terminate.
        // So, we still have remaining elements in the larger array.. iterate the while loop over that again        
        while(len2 >= 0)
        {
            nums1[totalLen--] = nums2[len2--];
        }
        
        return nums1;
    }

}

/*There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

*/
public class Paint_Fence_276 {
	/*We can use a DP solution. 
	  -- Define two DP arrays, diff[n] and same[i]. Where diff[i] means the number of ways for the fence i which has different color with fence i -1. same[i] means the number of ways if fence i has the same color with fence i - 1. 
	 --  Initialization same[0] = 0, diff[0] = k.
	 -- same[i] = diff[i - 1]. 
	 -- diff[i] = (k - 1) * (same[i - 1] + diff[i - 1]);*/
	
	/*
	int numWays(int n, int k) {
		 4         if (n < 2 || !k) return n * k; 
		 5         int s = k, d1 = k, d2 = k * (k - 1); 
		 6         for (int i = 2; i < n; i++) {
		 7             s = d2;
		 8             d2 = (k - 1) * (d1 + d2);
		 9             d1 = s;
		10         }
		11         return s + d2;
		12     }*/
}

/*Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]*/
public class ThreeSum_Smaller_259 {
	/*int threeSumSmaller(vector<int>& nums, int target) {
		          sort(nums.begin(), nums.end());
		          int n = nums.size(), ans = 0, i, j, k;
		          for (int i = 0; i < n - 2; i++) {
		              int j = i + 1, k = n - 1;
		              while (j < k) {
		                  if (nums[i] + nums[j] + nums[k] >= target) k--;
		                 else {
		                     ans += (k - j);
		                     j++;
		                 }
		             }
		         }
		         return ans;
		     }*/
}

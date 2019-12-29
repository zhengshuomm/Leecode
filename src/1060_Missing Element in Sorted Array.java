//Input: A = [4,7,9,10], K = 1
//Output: 5
//Explanation: 
//The first missing number is 5.
class Solution {
    public int missingElement(int[] nums, int k) {
        for (int i = 1 ; i < nums.length ; i ++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > k) {
                return nums[i - 1] + k;
            } else {
                k = k - diff + 1;
            }
        }
        return nums[nums.length - 1] + k;
    }
}
//Input: num_people = 4
//Output: 2
//Explanation: There are two ways to do it, the first way is [(1,2),(3,4)] and the second one is [(2,3),(4,1)].
class Solution {
    public int numberOfWays(int num_people) {
        int mod = 1000000007;
        long[] dp = new long[num_people + 1];
        dp[0] = 1;
        dp[2] = 1;
        
        for (int n = 4; n <= num_people; n++) {
            for (int k = 0; k <= n - 2; k += 2) {
                dp[n] += dp[k] * dp[n - k - 2];
                dp[n] %= 1000000007;
            }
        }
        
        return (int)dp[num_people];
    }
}
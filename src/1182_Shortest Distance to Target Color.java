//You are given an array colors, in which there are three colors: 1, 2 and 3.
//
//You are also given some queries. Each query consists of two integers i and c, return the shortest distance between the given index i and the target color c. If there is no solution return -1.

//Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
//Output: [3,0,3]
//Explanation: 
//The nearest 3 from index 1 is at index 4 (3 steps away).
//The nearest 2 from index 2 is at index 2 itself (0 steps away).
//The nearest 1 from index 6 is at index 3 (3 steps away).

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        final int max = 50_001;
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], max);
        dp[0][colors[0]-1] = 0;
        for(int i = 1; i < n; i++){
            dp[i][colors[i]-1] = 0;
            for(int j = 0; j < 3; j++) dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j]);
        }
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j < 3; j++) dp[i][j] = Math.min(dp[i+1][j] + 1, dp[i][j]);
        }
        int m = queries.length;
        List<Integer> res = new ArrayList(m);
        for(int i = 0; i < m; i++){
            int idx = queries[i][0], col = queries[i][1];
            if(dp[idx][col-1] >= max) res.add(-1);
            else res.add(dp[idx][col-1]);
        }
        return res;
    }
}
//Input: arr = [1,3,4,1,5]
//Output: 3
//Explanation: Remove [4] then remove [1,3,1] then remove [5].

class Solution {
public int minimumMoves(int[] A) {
    int n = A.length;
    // dp[i][j] represents the minimum number of ways to remove array[i] till array[j] inclusive
    // dp[i][j] = Math.min(dp[i+1][j-1] if A[i] == A[j], 
    //                      dp[i+1][j-1] + 2 if A[i] != A[j], 
    //                      dp[i][k] + dp[k][j] for k in the range of [i, j])
    
    // the first min is true because considering the example 1 2 3 1, the number of ways to remove it is 2 
    // which is the same as the number of ways to remove [2,3]
    // this part is a little bit tricky to begin with
    // the rest is pretty straightforward
    
    int[][] dp = new int[n][n];
    
    // initialization of dp for cases of len=1 and len=2
//     for (int i=0; i<n; i++) {
//         dp[i][i] = 1;
//         if (i<n-1) {
//             if (A[i] == A[i+1]) {
//                 dp[i][i+1] = 1;
//             } else {
//                 dp[i][i+1] = 2;
//             }
//         }
//     }
    
    for (int len=1; len <= n; len++) {
        for (int i=0; i<=n-len; i++) {
            int j = i + len-1;
            
            if (len == 1) {
                dp[i][j] = 1;
            } else if (len == 2) {
                if (A[i] == A[i+1]) {
                    dp[i][i+1] = 1;
                } else {
                    dp[i][i+1] = 2;
                }
            } else {
                if (A[i] == A[j]) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }

                for (int k=i; k<=j-1; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                }
            }
        }    
    }
    
    return dp[0][n-1]; 
}
}
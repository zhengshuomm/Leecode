//Given a non-decreasing array of positive integers nums and an integer K, find out if this array can be divided into one or more disjoint increasing subsequences of length at least K.

//Input: nums = [1,2,2,3,3,4,4], K = 3
//Output: true
//Explanation: 
//The array can be divided into the two subsequences [1,2,3,4] and [2,3,4] with lengths at least 3 each.

class Solution {
    public boolean canDivideIntoSubsequences(int[] A, int K) {
        int cur = 1, groups = 1, n = A.length;
        for (int i = 1; i < n; ++i) {
            cur = A[i - 1] < A[i] ?  1 : cur + 1;
            groups = Math.max(groups, cur);
        }
        return n >= K * groups; 
    }
}
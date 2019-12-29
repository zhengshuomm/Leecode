//From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
//Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1

//Input: source = "abc", target = "abcbc"
//Output: 2
//Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
class Solution {
    public int shortestWay(String source, String target) {
        char[] targets = target.toCharArray();
        int count = 1;
        int prevI = -1;
        int j = 0;
        for (int  i = 0 ; i < targets.length ; i ++) {
            while (j < source.length() && source.charAt(j) != targets[i]) j ++;
            if (j== source.length()) {
                if (prevI == i) return -1;
                prevI = i;
                i --;
                j = 0;
                count ++;
            } else {
                j ++;
            }
        }
        return count;
    }
}
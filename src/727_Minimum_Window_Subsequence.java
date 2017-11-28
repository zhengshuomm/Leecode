//Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
//
//If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
//
//Example 1:
//Input: 
//S = "abcdebdde", T = "bde"
//Output: "bcde"
//Explanation: 
//"bcde" is the answer because it occurs before "bdde" which has the same length.
//"deb" is not a smaller window because the elements of T in the window must occur in order.
public class Minimum_Window_Subsequence_727 {
	public String minWindow(String S, String T) {
        String output = "";
        int minLen = 20001;
        for (int i = 0; i <= S.length() - T.length(); i++) {
        	while (i < S.length() && S.charAt(i) != T.charAt(0)) {
        		i++;
        	}
        	int l = find(S.substring(i, Math.min(i + minLen, S.length())), T);
        	if (l != -1 && l < minLen) {
        		minLen = l;
        		output = S.substring(i, i + l);
        	}
        }
        return output;
    }
	
	private int find(String S, String T) {
		for (int i = 0, j = 0; i < S.length() && j < T.length();) {
			if (S.charAt(i) == T.charAt(j)) {
				i++;
				j++;
				if (j == T.length()) {
					return i;
				}
			} else {
				i++;
			}
		}
		return -1;
	}
}

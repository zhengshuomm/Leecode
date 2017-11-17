import java.util.ArrayList;
import java.util.List;
/*Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form. 

For example: 

Given s = "aabb", return ["abba", "baab"]. 

Given s = "abc", return []. */
public class Palindrome_Permutation_II_267 {
	
	/*思路1：按照leetcode的提示，我们仅需构造回文的前半部分。先利用前面判断过程中的map获得回文前半部分所有的字符，相同字符排列在一起，然后按照Permutation II一题的思路获得前半部分所有的排列情况，最后组合回文的前后部分加入结果集。 
	思路2：从中间往两端递归构造回文串。*/
	 // Method 2  
    public List<String> generatePalindromes2(String s) {  
        List<String> ret = new ArrayList<String>();  
        int[] map = new int[256];  
        for (int i = 0; i < s.length(); i++)  
            map[s.charAt(i)]++;  
        int oddCount = 0;  
        int oddIdx = -1;  
        for (int i = 0; i < 256; i++) {  
            if ((map[i] & 1) == 1) {  
                oddIdx = i;  
                oddCount++;  
                if (oddCount == 2) return ret;  
            }  
        }  
        String curr = "";  
        if (oddIdx != -1) {  
            curr += (char)oddIdx;  
            map[oddIdx]--;  
        }  
        dfs(curr, map, s.length(), ret);  
        return ret;  
    }  
    public void dfs(String curr, int[] map, int n, List<String> ret) {  
        if (curr.length() < n) {  
            for (int i = 0; i < map.length; i++) {  
                if (map[i] > 0) {  
                    curr = (char)i + curr + (char)i;  
                    map[i] -= 2;  
                    dfs(curr, map, n, ret);  
                    curr = curr.substring(1, curr.length() - 1);  
                    map[i] += 2;  
                }  
            }  
        } else {  
            ret.add(curr);  
        }  
    }  
}

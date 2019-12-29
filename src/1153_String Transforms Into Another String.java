//Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.
//
//In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
//
//Return true if and only if you can transform str1 into str2.

//Input: str1 = "aabcc", str2 = "ccdee"
//Output: true
//Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.

class Solution {
    // https://leetcode.com/problems/string-transforms-into-another-string/discuss/355420/Simple-java-solution
    public boolean canConvert(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        if (str1.equals(str2)) return true;
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int  i = 0 ; i < c1.length ; i ++) {
            if (map.containsKey(c1[i]) && map.get(c1[i]) != c2[i]) return false;
            map.put(c1[i], c2[i]);
        }
        // 至少有一个c 入度为0 在26个字母条件下
        Map<Character, Integer> degree = new HashMap<>();
        for (char c : map.keySet()) {
            // degree.put(c, degree.getOrDefault(c, 0) );
            degree.put(map.get(c), degree.getOrDefault(map.get(c), 0) + 1);
        }
        boolean found = false;
        // for (int val : degree.values()) {
        //     if (val == 0) found = true;
        // }
        if (degree.size() != 26) found = true;
        System.out.println(map);
        System.out.println(degree);
        return found;
    }
}
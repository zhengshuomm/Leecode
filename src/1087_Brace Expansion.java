//Input: "{a,b}c{d,e}f"
//Output: ["acdf","acef","bcdf","bcef"]

class Solution {
    public String[] expand(String S) {
        List<String> result = new ArrayList<>();
        dfs(result, "", S.toCharArray(), 0);
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    void dfs(List<String> result, String cur, char[] c, int index) {
        if (index == c.length) {
            result.add(cur);
            return;
        }    
        if (Character.isLetter(c[index])) {
            dfs(result, cur + c[index], c, index + 1);
        } else if (c[index] == '{') {
            int endIndex = index;
            while (c[endIndex] != '}') endIndex ++;
            for (int i = index + 1; i < endIndex; i ++) {
                if (c[i] == ',') continue;
                dfs(result, cur + c[i], c, endIndex + 1);
            }
        }
    }  
}
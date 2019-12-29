/*Write a function to generate the generalized abbreviations of a word.

Example:

Given word = "word", return the following list (order does not matter):

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]*/
public class Generalized_Abbreviation_320 {
	// http://www.cnblogs.com/grandyang/p/5261569.html
    vector<string> generateAbbreviations(string word) {
        vector<string> res;
        for (int i = 0; i < pow(2, word.size()); ++i) {
            string out = "";
            int cnt = 0, t = i;
            for (int j = 0; j < word.size(); ++j) {
                if (t & 1 == 1) {
                    ++cnt;
                    if (j == word.size() - 1) out += to_string(cnt);
                } else {
                    if (cnt != 0) {
                        out += to_string(cnt);
                        cnt = 0;
                    }
                    out += word[j];
                }
                t >>= 1;
            }
            res.push_back(out);
        }
        return res;
    }
    
    
    // Method 2. DFS
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(word, 0, 0, "", res);
        return res;
    }
    
    void helper(String word, int pos, int cnt, String out,  List<String> res) {
        if (pos == word.length()) {
            if (cnt > 0) out += cnt;
            res.add(out);
        } else {
            helper(word, pos + 1, cnt + 1, out, res);
            helper(word, pos + 1, 0, out + (cnt > 0 ? cnt : "") + word.charAt(pos), res);
        }
    }
}

//Given a sequence of words, check whether it forms a valid word square.
//
//A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ¡Ük < max(numRows, numColumns).
//
//Note:
//
//The number of words given is at least 1 and does not exceed 500.
//Word length will be at least 1 and does not exceed 500.
//Each word contains only lowercase English alphabet a-z.
public class Valid_word_square_422 {
    bool validWordSquare(vector<string>& words) {
        if (words.empty()) return true;
        if (words.size() != words[0].size()) return false;
        for (int i = 0; i < words.size(); ++i) {
            for (int j = 0; j < words[i].size(); ++j) {
                if (j >= words.size() || i >= words[j].size() || words[i][j] != words[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

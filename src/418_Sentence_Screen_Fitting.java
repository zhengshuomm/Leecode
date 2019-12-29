//Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.
//
//Input:
//rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
//
//Output: 
//2
//
//Explanation:
//a-bcd- 
//e-a---
//bcd-e-
//
//The character '-' signifies an empty space on the screen.

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int i = 0;
        int cnt = 0;

        int k = 0;  //kth word
        int colLen = cols;

        while (i < rows) {
            String sen = sentence[k++];
            if (sen.length() > cols) {
                return 0;
            }

            if (colLen >= sen.length()) {
                colLen = colLen - sen.length() - 1;
            } else {
                i++;
                colLen = cols;
                colLen = colLen - sen.length() - 1;
            }

            if (i >= rows) {
                return cnt;
            }

            if (k == sentence.length) {
                cnt++;
                k = 0;
            }
        }

        return cnt;
    }
    
	//  int n = sentence.length;
	//  int res = 0;
	 
	//  for(int i = 0; i < rows; i++){
	//      // 单个单词的长度太长了，放不下
	//      if(sentence[res % n].length() > cols) return 0;
	//      int len = sentence[res % n].length();
	//      res++;
	     
	//      while(len + 1 + sentence[res % n].length() <= cols){
	//          len += 1 + sentence[res % n].length();
	//          res++;
	//      }
	//  }
	 
	//  return res / n;
}
//Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
class Solution {
    public void reverseWords(char[] s) {
   		int lowIndex = 0;
		int highIndex = s.length - 1;
		swap(s, lowIndex, highIndex);

        //Loop through char array and reverse each individual word
		int currentWordLowIndex = 0;
		int currentWordHighIndex;
		for(int i = 0; i <= s.length - 1; i++) {
			if(i == s.length - 1 || s[i + 1] == ' ') {
				currentWordHighIndex = i;

				//Reverse the currentWord
				swap(s, currentWordLowIndex, currentWordHighIndex);

				currentWordLowIndex = i + 2;
			}
		}
    }
    
    public static void swap(char[] array, int lowIndex, int highIndex) {
		while(lowIndex < highIndex) {
			char temp = array[lowIndex];
			array[lowIndex] = array[highIndex];
			array[highIndex] = temp;
			lowIndex++;
			highIndex--;
		}
	}
}
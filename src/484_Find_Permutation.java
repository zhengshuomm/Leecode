//Example 1:
//
//Input: "I"
//Output: [1,2]
//Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I", where the number 1 and 2 construct an increasing relationship.
// 
//
//Example 2:
//
//Input: "DI"
//Output: [2,1,3]
//Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI", 
//but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]
public class Find_Permutation_484 {
//	D D I I D I
//
//	1 2 3 4 5 6 7
//
//	3 2 1 4 6 5 7
    public int[] findPermutation(String s) {
        int n = s.length(), arr[] = new int[n + 1]; 
        for (int i = 0; i <= n; i++) arr[i] = i + 1; // sorted
        for (int h = 0; h < n; h++) {
            if (s.charAt(h) == 'D') {
                int l = h;
                while (h < n && s.charAt(h) == 'D') h++;
                reverse(arr, l, h); 
            }   
        }   
        return arr;
    }   

    void reverse(int[] arr, int l, int h) {
        while (l < h) {
            arr[l] ^= arr[h];
            arr[h] ^= arr[l];
            arr[l] ^= arr[h];
            l++; h--;
        }   
    }
}

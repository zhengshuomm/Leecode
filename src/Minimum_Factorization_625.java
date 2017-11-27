//Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.
//
//If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
//
//Example 1
//Input:
//
//48 
//Output:
//68
// 
//
//Example 2
//Input:
//
//15
//Output:
//35
// 
public class Minimum_Factorization_625 {
    int smallestFactorization(int a) {
        if (a == 1) return 1;
        string res = "";
        for (int k = 9; k >= 2; --k) {
            while (a % k == 0) {
                res = to_string(k) + res;
                a /= k;
            }
        }
        if (a > 1) return 0;
        long long num = stoll(res);
        return num > INT_MAX ? 0 : num;
    }
}

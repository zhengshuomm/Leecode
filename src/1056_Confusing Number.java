//Given a number N, return true if and only if it is a confusing number, which satisfies the following condition:

//We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid. A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
class Solution {
    public boolean confusingNumber(int N) {
        if(N == 0){
            return false;
        }
        int num = 0;
        int tmp = N;
        while(N != 0){
            int n = N % 10;
            if(n != 0&& n != 1 && n != 6 && n != 8 && n!=9){
                return false;
            }
            if(n == 6 || n == 9){
                n = n == 6 ? 9 : 6;
            }
            num = num*10 + n;
            N = N/10;
        }
        if(num != tmp){
            return true;
        }
        return false;               
    }
}
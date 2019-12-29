//We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
//
//A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.(Note that the rotated number can be greater than the original number.)
//
//Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.

//Input: 20
//Output: 6
//Explanation: 
//The confusing numbers are [6,9,10,16,18,19].
//6 converts to 9.
//9 converts to 6.
//10 converts to 01 which is just 1.
//16 converts to 91.
//18 converts to 81.
//19 converts to 61.

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int[] num = {0, 1, 6, 8, 9};
    public int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int count[] = new int[1];
        dfs(0, N, num, count);
        return count[0];
    }
    private void dfs(long start, int N, int[] num, int[] count){
        if(start > N){
            return;
        }
        if(start <= N && isConfused(start, map)){
            count[0]++;
        }
        int i = start == 0 ? 1 : 0;
        for(; i < 5; i++){
            dfs(start * 10 + num[i], N, num, count);
        }
    }
    private boolean isConfused(long s, Map<Integer, Integer> map){
        long res = 0, x = s;
        while(x > 0){
            int i = (int) (x % 10);
            if(i == 2 || i == 3 || i == 4 || i == 5 || i == 7){
                return false;
            }
            long digit = map.get(i);
            res = res * 10 + digit;
            x = x / 10;
        }
        return res != s;
    }
}
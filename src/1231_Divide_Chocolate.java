//Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
//Output: 6
//Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]

class Solution {
    // 同wood cut
    public int maximizeSweetness(int[] sweetness, int K) {
        int sum = 0;
        for (int s : sweetness) {
            sum += s;
        }
        int low = 1; 
        int high = sum / (K + 1) + 1; // 让high一定不match
        System.out.println(high);
        while (low < high - 1) {
            int mid = low + (high- low) / 2;
            if (can(mid, sweetness, K)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    private boolean can(int mid, int[] array, int K) {
        int count = 0;
        int tmp = 0;
        for (int num : array) {
            tmp += num;
            if (tmp >= mid) {
                count ++;
                tmp = 0;
                if (count == K + 1) return true;
            }
        }
        return false;
    }
}
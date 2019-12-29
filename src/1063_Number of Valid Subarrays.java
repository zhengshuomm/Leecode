//Given an array A of integers, return the number of non-empty continuous subarrays that satisfy the following condition:
//
//The leftmost element of the subarray is not larger than other elements in the subarray.
//Input: [1,4,2,5,3]
//Output: 11
//Explanation: There are 11 valid subarrays: [1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3].
class Solution {
    public int validSubarrays(int[] nums) {
        Deque<Integer> queue = new LinkedList<Integer>();
        int result = nums.length;
        for (int i = 0 ;i < nums.length ; i ++) {
            if (queue.isEmpty()){
                queue.add(i);
            } else {
                int num = nums[i];
                int first = nums[queue.peek()];
                if (first <= num) {
                    result ++;
                }
                int last2 = queue.peekLast();
                int count = 0;
                while (!queue.isEmpty() && nums[queue.peekLast()] > num) {
                    int last1 = queue.pollLast();
                    count ++;
                    if (count > 1 && !queue.isEmpty()) {
                        result += last2 - last1;
                    }
                }
                queue.add(i);
            }
        }
        
        queue.poll();
        while (queue.size()> 1){
            int first = queue.poll();
            int second = queue.peekLast();
            result += second - first;
        }
        return result;
    }
}
//You have some sticks with positive integer lengths.
//
//You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.
//
//Return the minimum cost of connecting all the given sticks into one stick in this way.

//Input: sticks = [2,4,3]
//Output: 14

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : sticks) {
            queue.add(num);
        }
        int sum = 0;
        while (queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();
            sum += a + b;
            queue.add(a +b);
        }
        return sum;
    }
}
//There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.
//
//Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.
//
//For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.
//
//Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.
//
//If there isn't such day, output -1.
public class K_Empty_Slots_683 {
//	The idea is to use an array days[] to record each position's flower's blooming day. 
//	That means days[i] is the blooming day of the flower in position i+1. 
//	We just need to find a subarray days[left, left+1,..., left+k-1, right] which satisfies: 
//	for any i = left+1,..., left+k-1, we can have days[left] < days[i] && days[right] < days[i]. 
//	Then, the result is max(days[left], days[right]).
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> active = new TreeSet();
        int day = 0;
        for (int flower: flowers) {
            day++;
            active.add(flower);
            Integer lower = active.lower(flower);
            Integer higher = active.higher(flower);
            if (lower != null && flower - lower - 1 == k ||
                    higher != null && higher - flower - 1 == k)
                return day;
        }
        return -1;
    }
    
    // days index表示第几个flower， days[i] 表示第几天开
    int[] days = new int[flowers.length + 1];
    for (int i = 0; i < flowers.length; i++) {
        days[flowers[i]] = i + 1;
    }
 
    int result = Integer.MAX_VALUE;
 
    for (int i = 1; i < days.length - k - 1; i++) {
        int l = days[i];
        int r = days[i + k + 1];
 
        int max = Math.max(l, r);
        int min = Math.min(l, r);
 
 
        boolean flag = true;
        for (int j = 1; j <= k; j++) {
            if (days[i + j] < max) {
                flag = false;
                break;
            }
        }
 
        if (flag && max < result) {
            result = max;
        }
    }
 
    return result == Integer.MAX_VALUE ? -1 : result;
}

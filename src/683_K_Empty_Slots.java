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
        int[] days =  new int[flowers.length];
        for(int i=0; i<flowers.length; i++)days[flowers[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for(int i = 0; right < days.length; i++){
            if(days[i] < days[left] || days[i] <= days[right]){
                if(i == right)res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i; 
                right = k + 1 + i;
            }
        }
        return (res == Integer.MAX_VALUE)?-1:res;
    }
}

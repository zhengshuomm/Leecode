//Given an array consisting of n integers, find the contiguous subarray whose length is greater than or equal to k that has the maximum average value. And you need to output the maximum average value.
//
//Example 1:
//Input: [1,12,-5,-6,50,3], k = 4
//Output: 12.75
//Explanation:
//when length is 5, maximum average value is 10.8,
//when length is 6, maximum average value is 9.16667.
//Thus return 12.75.
public class Maximum_Average_Subarray_II_644 {
	public double findMaxAverage(int[] nums, int k) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        // 寻找最值
        for (int n: nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        while (max-min > 0.00001) {
            double mid = (max + min) / 2.0;
            if (check(nums, mid, k))
                min = mid;
            else
                max = mid;
        }
        return min;   
    }


    // 判断这个区间里面，是否有一段大于等于K的长度的最长序列，满足要求，就是最大的累计和，减去最小的累积和
    public boolean check(int[] nums, double mid, int k) {
        double sum = 0, prev = 0, min_sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i] - mid;
        if (sum >= 0)
            return true;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i - k] - mid;
            min_sum = Math.min(prev, min_sum);
            if (sum >= min_sum)
                return true;
        }
        return false;
    }
    
    /*boolean check(int[] nums,int k,double x) //Check whether we can find a subarray whose average is bigger than x
    {
        int n=nums.length;
        double[] a=new double[n];
        for (int i=0;i<n;i++) a[i]=nums[i]-x; //Transfer to a[i], find whether there is a subarray whose sum is bigger than 0
        double now=0,last=0;
        for (int i=0;i<k;i++) now+=a[i];
        if (now>=0) return true;
        for (int i=k;i<n;i++)
        {
            now+=a[i];
            last+=a[i-k];
            if (last<0) 
            {
                now-=last;
                last=0;
            }
            if (now>=0) return true;
        }
        return false;
    }*/
}

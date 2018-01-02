
public class Max_Night {
	public int rob(int[] nums) {
		int lo = 0, hi = nums.length - 1;
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
	}
}

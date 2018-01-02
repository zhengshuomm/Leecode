import java.util.Arrays;
import java.util.Comparator;

public class Round_Price {
	public static void main(String[] args) {
		double a = 3.6;
		int b = (int) a;
		System.out.println(b);
	}

	public int[] roundUp(double[] arr) {
		int n = arr.length;
		NumWithDiff[] arrWithDiff = new NumWithDiff[n];
		double sum = 0.0;
		int floorSum = 0;
		for (int i = 0; i < n; i++) {
			int floor = (int) arr[i];
			int ceil = floor;
			if (floor < arr[i])
				ceil++;
			floorSum += floor;
			sum += arr[i];
			arrWithDiff[i] = new NumWithDiff(ceil, ceil - arr[i]);
		}
		int num = (int) Math.round(sum);
		int diff = num - floorSum;
		Arrays.sort(arrWithDiff, new Comparator<NumWithDiff>() {
			@Override
			public int compare(NumWithDiff n1, NumWithDiff n2) {
				if (n1.diffWithCeil <= n2.diffWithCeil)
					return -1;
				else
					return 1;
			}
		});
		int[] res = new int[n];
		int i = 0;
		for (; i < diff; i++) {
			res[i] = arrWithDiff[i].num;
		}
		for (; i < n; i++) {
			res[i] = arrWithDiff[i].num - 1;
		}
		return res;
	}

}

class NumWithDiff {
	int num;
	double diffWithCeil;

	public NumWithDiff(int n, double c) {
		this.num = n;
		this.diffWithCeil = c;
	}
}

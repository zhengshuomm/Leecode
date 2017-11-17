import java.util.Arrays;

/*Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].*/
public class Wiggle_Sort_280 {
	public static void main(String[] args) {
		int[] array = {3, 5, 2, 1, 6, 4};
		wiggleSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void wiggleSort(int[] array) {
		for (int i = 1 ; i < array.length ; i ++){
			if (i % 2 == 1){
				if (array[i] < array[i - 1]){
					swap(array, i, i - 1);
				}
			}else{
				if (array[i] > array[i - 1]){
					swap(array, i, i - 1);
				}
			}
		}
	}
	
	private static void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}

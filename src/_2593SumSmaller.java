import java.util.Arrays;

public class _2593SumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length < 3) return 0;
		Arrays.sort(nums);
		int n = nums.length;
		int[] res = new int[1];
		for (int i = 0; i < n - 2; i++) {
			twoSum(nums, i + 1, target - nums[i], res);
		}
		return res[0];
	}

	private void twoSum(int[] nums, int start, int target, int[] res) {
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] < target) {
				res[0] += end - start;
				start++;
			} else {
				end--;
			}
		}
	}
}

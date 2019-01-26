import java.util.Arrays;

public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}

		Arrays.sort(nums);
		int[] res = new int[1];
		for (int i = 0; i < nums.length - 2; i++) {

			twoSum(res, target - nums[i], i + 1, nums);
		}
		return res[0];
	}

	private void twoSum(int[] res,
						int target,
						int start,
						int[] nums) {
		// int res = 0;
		int s = start;
		int e = nums.length - 1;

		while (s < e) {
			if (nums[s] + nums[e] < target) {
				res[0] += e - s;
				s++;
			} else {
				e--;
			}
		}
	}
}

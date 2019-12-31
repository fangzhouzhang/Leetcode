import java.util.Arrays;

public class _16ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) return 0;
		Arrays.sort(nums);
		return getClosest(nums, target);
	}

	private int getClosest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int rem = target - nums[i];
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				if (nums[start] + nums[end] == rem) {
					return target;
				} else {
					if (Math.abs(nums[start] + nums[end] + nums[i] - target) < diff) {
						diff = Math.abs(nums[start] + nums[end] + nums[i] - target);
						res = nums[start] + nums[end] + nums[i];
					}
					if (nums[start] + nums[end] > rem) {
						end--;
					} else {
						start++;
					}
				}
			}
		}
		return res;
	}
}

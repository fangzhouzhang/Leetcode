import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);

		return getCloest(nums, target);
	}

	private int getCloest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE;
		int res = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int t = target - nums[i];
			int s = i + 1;
			int e = nums.length - 1;
			while (s < e) {
				if (nums[s] + nums[e] == t) {
					return target;
				} else if (nums[s] + nums[e] < t) {
					if (Math.abs(nums[s] + nums[e] - t) < diff) {
						res = nums[i] + nums[s] + nums[e];
						diff = Math.abs(nums[s] + nums[e] - t);
					}
					s++;
				} else {//nums[s] + nums[e] > t
					if (Math.abs(nums[s] + nums[e] - t) < diff) {
						res = nums[i] + nums[s] + nums[e];
						diff = Math.abs(nums[s] + nums[e] - t);
					}
					e--;
				}
			}
		}
		return res;
	}
}

public class MaximumGap {
	public int maximumGap(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}
		//get min and max value
		int min = nums[0];
		int max = nums[0];
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		//smallest biggest gap
		int gap = (int)Math.ceil((double) (max - min) * 1.0 / (nums.length - 1));
		int[] bmin = new int[nums.length - 1];
		int[] bmax = new int[nums.length - 1];
		for (int i = 0; i < bmin.length; i++) {
			bmin[i] = Integer.MAX_VALUE;
			bmax[i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == min || nums[i] == max) {
				continue;
			}
			int idx = (nums[i] - min) / gap;
			bmin[idx] = Math.min(bmin[idx], nums[i]);
			bmax[idx] = Math.max(bmax[idx], nums[i]);
		}

		int prev = min;
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < bmin.length; i++) {
			if (bmin[i] == Integer.MAX_VALUE || bmax[i] == Integer.MIN_VALUE) {
				continue;
			}
			res = Math.max(bmin[i] - prev, res);
			prev = bmax[i];
		}
		return Math.max(res, max - prev);
	}
}

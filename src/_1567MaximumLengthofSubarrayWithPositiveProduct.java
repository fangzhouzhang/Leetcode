public class _1567MaximumLengthofSubarrayWithPositiveProduct {
	public int getMaxLen(int[] nums) {
		int n = nums.length;
		int max = 0;
		//find each [start, end]
		//1. all positive or even number of neg
		//2. odd number of neg,kick the 1st or the last neg number
		//compare max
		int cur = 0;
		while (cur < n) {
			while (cur < n && nums[cur] == 0) cur++;
			int start = -1;
			if (cur < n) {
				start = cur;
			}
			if (start == -1) break;
			while (cur < n && nums[cur] != 0) cur++;
			int end = -1;
			if (cur < n) {
				end = cur - 1;
			} else {
				end = n - 1;
			}

			int negCount = 0, first = -1, last = -1;
			for (int k = start; k <= end; k++) {
				if (nums[k] < 0) {
					negCount++;
					if (first == -1) {
						first = k;
						last = k;
					} else {
						last = k;
					}
				}
			}
			if (negCount % 2 == 0) {
				max = Math.max(max, end - start + 1);
			} else {
				max = Math.max(max, end - first);
				if (last != -1) max = Math.max(max, last - start);
			}
		}
		return max;
	}
}

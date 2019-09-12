public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		long left = Integer.MIN_VALUE;
		long right = 0;
		for (int num : nums) {
			left = Math.max(left, num);
			right += num;
		}
		long res = right;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			long sum = 0;
			long cnt = 1;
			for (int n : nums) {
				if (sum + n > mid) {
					cnt++;
					sum = n;
				} else {
					sum += n;
				}
			}
			if (cnt <= m) {
				res = Math.min(res, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int)res;
	}
}

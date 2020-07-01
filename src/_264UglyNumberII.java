public class _264UglyNumberII {

	public int nthUglyNumber(int n) {
		int[] nums = new int[n];
		nums[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0,curNum = 1;
		while (curNum < n) {
			int next = Math.min(nums[i2] * 2, Math.min(nums[i3] * 3, nums[i5] * 5));
			if (next == nums[i2] * 2) i2++;
			if (next == nums[i3] * 3) i3++;
			if (next == nums[i5] * 5) i5++;
			nums[curNum++] = next;
		}
		return nums[n - 1];
	}
}

public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		if (nums.length == 0) {
			return new int[0];
		}
		int[] res = new int[nums.length];
		int idx = a >= 0 ? nums.length - 1 : 0;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int startVal = calc(nums, start, a, b, c);
			int endVal = calc(nums, end, a, b, c);
			if (a >= 0) {
				if (startVal > endVal) {
					res[idx--] = startVal;
					start++;
				} else {
					res[idx--] = endVal;
					end--;
				}
			} else {
				if (startVal < endVal) {
					res[idx++] = startVal;
					start++;
				} else {
					res[idx++] = endVal;
					end--;
				}
			}
		}
		return res;
	}

	private int calc(int[] nums, int idx, int a, int b, int c) {
		int res = 0;
		res += nums[idx] * nums[idx] * a + b * nums[idx] + c;
		return res;
	}
}

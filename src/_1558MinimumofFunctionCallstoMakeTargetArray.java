public class _1558MinimumofFunctionCallstoMakeTargetArray {
	public int minOperations(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int ones = 0;
		int high = 0;
		for (int num : nums) {
			int h = 0;
			while (num != 0) {
				ones += (num & 1);
				num >>= 1;
				h++;
			}
			high = Math.max(high, h - 1);
		}
		return ones + high;
	}
}

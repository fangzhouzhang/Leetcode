public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if (nums == null || nums.length < 2) {
			return false;
		}
		int[] prefix = new int[nums.length + 1];
		getPrefix(prefix, nums);
		for (int offset = 2; offset < prefix.length; offset++) {
			for (int i = 0; i + offset < prefix.length; i++) {
				if (k == 0 && (prefix[i + offset] - prefix[i] == 0)) {
					return true;
				} else if (k != 0 && (prefix[i + offset] - prefix[i]) % k == 0) {
					return true;
				}
			}
		}
		return false;
	}
	private void getPrefix(int[] prefix, int[] nums) {
		int temp = 0;
		for (int i = 1; i < prefix.length; i++) {
			temp += nums[i - 1];
			prefix[i] = temp;
		}
	}
}

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int start = 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				res = Math.min(res, i - start + 1);
				sum -= nums[start++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}

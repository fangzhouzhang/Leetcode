public class _209MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = Integer.MAX_VALUE, cur_sum = 0, slow = 0, fast = 0;
		int n = nums.length;
		while (fast < n) {
			cur_sum += nums[fast];
			while (cur_sum >= s) {
				res = Math.min(res, fast - slow + 1);
				cur_sum -= nums[slow++];
			}
			fast++;
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}

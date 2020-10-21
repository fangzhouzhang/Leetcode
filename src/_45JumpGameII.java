public class _45JumpGameII {
	public int jump(int[] nums) {
		if (nums == null || nums.length <= 1) return 0;
		int n = nums.length;
		int start = 0, end = 0;
		int res = 0;
		while (start <= end) {
			int end_new = end;
			for (int i = start; i <=end; i++) {
				end_new = Math.max(end_new, i + nums[i]);
				if (end_new >= n - 1) return res + 1;
			}
			start = end + 1;
			end = end_new;
			res++;
		}
		return -1;
	}
}

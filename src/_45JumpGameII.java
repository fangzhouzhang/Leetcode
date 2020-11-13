public class _45JumpGameII {
	public int jump(int[] nums) {
		if (nums == null || nums.length <= 1) return 0;
		int start = 0, end = 0;
		int res = 0, n = nums.length;
		while (true) {
			int new_end = end;
			for (int i = start; i <= end; i++) {
				new_end = Math.max(new_end, nums[i] + i);
				if (new_end >= n - 1) return res + 1;
			}
			start = end + 1;
			end = new_end;
			res++;
		}
	}
}

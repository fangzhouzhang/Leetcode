public class _1749MaximumAbsoluteSumofAnySubarray {
	public int maxAbsoluteSum(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int max = nums[0], min = nums[0];
		int[][] arr = new int[n][2];
		arr[0][0] = max;
		arr[0][1] = min;
		for (int i = 1; i < n; i++) {
			arr[i][0] = Math.max(arr[i - 1][0] + nums[i], nums[i]);
			arr[i][1] = Math.min(arr[i - 1][1] + nums[i], nums[i]);
			max = Math.max(max, arr[i][0]);
			min = Math.min(min, arr[i][1]);
		}
		return Math.max(max, Math.abs(min));
	}
}

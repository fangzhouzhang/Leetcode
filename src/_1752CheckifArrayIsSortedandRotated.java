public class _1752CheckifArrayIsSortedandRotated {
	public boolean check(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		int n = nums.length;
		int min = Integer.MAX_VALUE, min_idx = -1;
		for (int i = 0; i < n; i++) {
			if (min > nums[i]) {
				min_idx = i;
				min = nums[i];
			}
		}
		for (int i = n - 1; i >= 0 && nums[i] == min; i--) {
			min_idx = i;
		}
		for (int i = 0; i < n; i++) {
			int real_idx = (i + n - min_idx) % n;
			for (int j = 0; j < n; j++) {
				int convert = (j + n - min_idx) % n;
				if (convert < real_idx && nums[j] > nums[i]) return false;
				if (convert > real_idx && nums[j] < nums[i]) return false;
			}
		}
		return true;
	}
}

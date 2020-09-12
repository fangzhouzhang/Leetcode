import java.util.Arrays;

public class _594LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < n; i++) {
			int min = nums[i];
			int max = nums[i];
			int j = i + 1;
			for (; j < n; j++) {
				min = Math.min(min, nums[j]);
				max = Math.max(max, nums[j]);
				if (max - min == 1) res = Math.max(res, j - i + 1);
				if (max - min > 1) break;
			}

		}
		return res;
	}
}

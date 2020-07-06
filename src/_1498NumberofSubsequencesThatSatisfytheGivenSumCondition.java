import java.util.Arrays;

public class _1498NumberofSubsequencesThatSatisfytheGivenSumCondition {
	int M = 1000000007;
	public int numSubseq(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		Arrays.sort(nums);
		int n = nums.length;
		int res = 0;
		int[] power = new int[n];
		power[0] = 1;
		for (int i = 1; i < n; i++) {
			power[i] = power[i - 1] * 2 % M;
		}

		int i = 0, j = n - 1;
		while (i <= j) {
			if (nums[i] + nums[j] > target) j--;
			else {
				res = (res + power[j - i]) % M;
				i++;
			}
		}
		return res;
	}
}

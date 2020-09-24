import java.util.Arrays;

public class _1589MaximumSumObtainedofAnyPermutation {
	private int M = 1000000007;
	public int maxSumRangeQuery(int[] nums, int[][] requests) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] diff = new int[n + 1];
		for (int[] r : requests) {
			diff[r[0]]++;
			diff[r[1] + 1]--;
		}
		//diff[i] = freq[i] - freq[i - 1]
		int[] fre = new int[n];
		int pre = 0;
		for (int i = 0; i < n; i++) {
			pre += diff[i];
			fre[i] = pre;
		}
		Arrays.sort(fre);
		Arrays.sort(nums);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum = (sum + (long)nums[i] * (long)fre[i]) % M;
		}
		return (int) sum;
	}
}

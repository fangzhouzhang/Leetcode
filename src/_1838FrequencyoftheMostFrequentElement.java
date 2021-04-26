import java.util.Arrays;

public class _1838FrequencyoftheMostFrequentElement {
	public int maxFrequency(int[] nums, int k) {
		int n = nums.length;
		long sum = 0;
		int l = 0, r = 0;
		int res = 0;
		Arrays.sort(nums);
		while (r < n) {
			sum += nums[r];
			while (l <= r && nums[r] * (r - l + 1) > k + sum) {
				sum -= nums[l];
				l++;
			}
			res = Math.max(res, r - l + 1);
			r++;
		}
		return res;
	}
}

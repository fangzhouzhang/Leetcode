import java.util.Arrays;

public class _719FindKthSmallestPairDistance {
	public int smallestDistancePair(int[] nums, int k) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		Arrays.sort(nums);
		int l = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			l = Math.min(l, nums[i] - nums[i - 1]);
		}
		int r = nums[n - 1] - nums[0];
		while (l < r) {
			int mid = l + r >> 1;
			if (countPair(nums, mid) >= k) r = mid;
			else l = mid + 1;
		}
		return l;
	}

	private int countPair(int[] a, int val) {
		int res = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int l = i + 1, r = n - 1;
			while (l < r) {
				int mid = l + r + 1 >> 1;
				if (a[mid] - a[i] <= val) l = mid;
				else r = mid - 1;
			}
			res += r - i;
		}
		return res;
	}
}

import java.util.ArrayList;
import java.util.List;

public class _673NumberofLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int targetLen = lengthOfLIS(nums);

		int n = nums.length;
		if (targetLen == 1) return n;
		int[][] a = new int[n][3];
		for (int[] b : a) {
			b[0] = 1;
			b[1] = 1;
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			int curMax = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					curMax = Math.max(curMax, a[j][0] + 1);
				}
			}
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && curMax == a[j][0] + 1 && a[i][2] != 0) {
					a[i][1] += a[j][1];
				}
				if (nums[i] > nums[j] && curMax == a[j][0] + 1 && a[i][2] == 0) {
					a[i][1] = a[j][1];
					a[i][2] = 1;
				}
			}
			a[i][0] = curMax;
			if (targetLen == curMax) res += a[i][1];
		}
		return res;
	}

	private int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		List<Integer> ns = new ArrayList<>();
		for (int n : nums) {
			if (ns.isEmpty() || ns.get(ns.size() - 1) < n) {
				ns.add(n);
			} else {
				int start = 0, end = ns.size() - 1;
				while (start <= end) {
					int mid = start + (end - start) / 2;
					if (ns.get(mid) < n) {
						start = mid + 1;
					} else if (ns.get(mid) >= n) {
						end = mid - 1;
					}
				}
				ns.set(start, n);
			}
		}
		return ns.size();
	}
}

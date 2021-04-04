import java.util.Comparator;
import java.util.TreeSet;

public class _1818MinimumAbsoluteSumDifference {
	int M = 1000000007;
	public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		int max_diff = Integer.MIN_VALUE, idx = -1, res = 0;
		for (int i = 0; i < nums1.length; i++) {
			int cur = Math.abs(nums1[i] - nums2[i]);
			if (cur > max_diff) {
				idx = i;
			}
			max_diff = Math.max(max_diff, cur);
			res = (res + cur) % M;
		}
		if (res == 0) return 0;
		TreeSet<Integer> set = new TreeSet<>(new MC(nums2[idx]));
		for (int i = 0; i < nums1.length; i++)
			if (i != idx) set.add(nums1[i]);
		return (res - max_diff + Math.abs(set.first() - nums2[idx])) % M;
	}

	private class MC implements Comparator<Integer> {
		int t = 0;
		public MC(int t) {
			this.t = t;
		}

		public int compare(Integer a, Integer b) {
			return Math.abs(a - t) - Math.abs(b - t);
		}
	}
}

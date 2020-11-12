import java.util.ArrayList;
import java.util.List;

public class _300LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
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

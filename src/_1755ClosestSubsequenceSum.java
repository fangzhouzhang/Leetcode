import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1755ClosestSubsequenceSum {
	public int minAbsDifference(int[] nums, int goal) {
		if (nums == null || nums.length == 0) return 0;
		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();
		int n = nums.length;
		dfs(first, nums, 0, n / 2, 0);
		Collections.sort(first);
		dfs(second, nums, n / 2, n, 0);

		int res = Integer.MAX_VALUE;
		for (int a : second) {
			int diff = goal - a;
			// find 1st element >= diff
			int l = 0, r = first.size() - 1;
			while (l < r) {
				int mid = l + r >> 1;
				if (first.get(mid) >= diff) r = mid;
				else l = mid + 1;
			}
			int firstIdx = l;
			// find the last element <= diff
			l = 0;r = first.size() - 1;
			while (l < r) {
				int mid = l + r + 1 >> 1;
				if (first.get(mid) <= diff) l = mid;
				else r = mid - 1;
			}
			int lastIdx = l;
			int d1 = Math.abs(goal - a - first.get(firstIdx)), d2 = Math.abs(goal - a - first.get(lastIdx));
			if (d1 == 0 || d2 == 0) return 0;
			res = Math.min(res, Math.min(d1, d2));
		}
		return res;
	}

	private void dfs(List<Integer> first, int[] a, int idx, int end, int sum) {
		if (idx == end) {
			first.add(sum);
			return;
		}

		dfs(first, a, idx + 1, end, sum + a[idx]);

		dfs(first, a, idx + 1, end, sum);
	}
}

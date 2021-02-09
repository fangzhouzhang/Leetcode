import java.util.TreeSet;

public class _1755ClosestSubsequenceSum {
	public int minAbsDifference(int[] nums, int goal) {
		if (nums == null || nums.length == 0) return 0;
		TreeSet<Integer> first = new TreeSet<>();
		TreeSet<Integer> second = new TreeSet<>();
		int n = nums.length;
		dfs(first, nums, 0, n / 2, 0);
		dfs(second, nums, n / 2, n, 0);

		int res = Integer.MAX_VALUE;
		for (int a : first) {
			Integer floor = second.floor(goal - a);
			if (floor != null) {
				res = Math.min(res, Math.abs(goal - a - floor));
			}
			Integer ceil = second.ceiling(goal - a);
			if (ceil != null) {
				res = Math.min(res, Math.abs(goal - a - ceil));
			}
		}
		return res;
	}

	private void dfs(TreeSet<Integer> first, int[] a, int idx, int end, int sum) {
		if (idx == end) {
			first.add(sum);
			return;
		}

		dfs(first, a, idx + 1, end, sum + a[idx]);

		dfs(first, a, idx + 1, end, sum);
	}
}

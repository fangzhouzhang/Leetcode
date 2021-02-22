import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1766TreeofCoprimes {
	public int[] getCoprimes(int[] nums, int[][] edges) {
		if (nums == null || nums.length == 0) return new int[0];
		int n = nums.length;
		List<Integer>[] g = new List[n];
		for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
		for (int[] e : edges) {
			g[e[0]].add(e[1]);
			g[e[1]].add(e[0]);
		}
		List<Integer>[] pre = new List[51];
		for (int i = 0; i <= 50; i++) pre[i] = new ArrayList<>();
		for (int i = 1; i <= 50; i++) {
			for (int j = 1; j <= 50; j++) {
				if (gcd(i, j) == 1) {
					pre[i].add(j);
				}
			}
		}
		int[] res = new int[n];
		boolean[] visit = new boolean[n];
		// depth[i] means the latest depth where i appears
		Pair[] depth = new Pair[51];
		for (int i = 0; i < 51; i++) {
			depth[i] = new Pair(-1, -1);
		}
		depth[0].id = 0;
		depth[0].depth = 0;
		Arrays.fill(res, -1);
		dfs(0, nums, g, res, visit, pre, 0, depth);
		return res;
	}

	private void dfs(int cur, int[] nums, List<Integer>[] g, int[] res, boolean[] visit, List<Integer>[] pre, int level, Pair[] depth) {
		visit[cur] = true;
		// traverse all primes p belonging to cur, find the largest depth
		// if finding, set res[cur]= p
		// otherwise do nothing
		int closeDepth = -1, cop = -1, val = nums[cur];
		for (int w : pre[val]) {
			// depth = -1 means never appear
			if (depth[w].depth == -1) continue;
			if (closeDepth < depth[w].depth) {
				closeDepth = depth[w].depth;
				cop = depth[w].id;
			}
		}
		if (cop != -1) {
			res[cur] = cop;
		}
		int tmpDepth = depth[val].depth;
		int tmpId = depth[val].id;
		depth[val].depth = level;
		depth[val].id = cur;
		for (int w : g[cur]) {
			if (!visit[w]) {
				dfs(w, nums, g, res, visit, pre, level + 1, depth);
			}
		}
		depth[val].depth = tmpDepth;
		depth[val].id = tmpId;
	}

	private int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	private class Pair {
		int id;
		int depth;
		public Pair(int id, int depth) {
			this.id = id;
			this.depth = depth;
		}
	}
}

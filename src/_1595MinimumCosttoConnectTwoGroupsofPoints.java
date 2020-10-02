import java.util.Arrays;
import java.util.List;

public class _1595MinimumCosttoConnectTwoGroupsofPoints {
	int m = 0;
	int n = 0;
	int[] mcost2;
	public int connectTwoGroups(List<List<Integer>> cost) {
		if (cost == null || cost.size() == 0 || cost.get(0).size() == 0) return 0;
		m = cost.size();
		n = cost.get(0).size();
		Integer[][] dp = new Integer[m][1 << n];
		// minimum cost for smaller group
		mcost2 = new int[n];
		Arrays.fill(mcost2, Integer.MAX_VALUE);
		// populate the minimum cost to connect group2 without any consideration for grp 1
		for(int j = 0; j < n; j++){
			for(int i = 0; i < m; i++){
				mcost2[j] = Math.min(mcost2[j], cost.get(i).get(j));
			}
		}
		return dfs(dp, 0, 0, cost);
	}

	private int dfs(Integer[][] dp, int row, int state, List<List<Integer>> cost) {
		if (row == m) {
			if (state == (1 << n) - 1) {
				return 0;
			} else {
				int res = 0;
				for (int i = 0; i < n; i++) {
					if ((state & (1 << i)) == 0) {
						res += mcost2[i];
					}
				}
				return res;
			}
		}
		if (dp[row][state] != null) return dp[row][state];
		int res = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			int ret = dfs(dp, row + 1, state | (1 << j), cost);
			if (ret == Integer.MAX_VALUE) continue;
			res = Math.min(res, cost.get(row).get(j) + ret);
		}
		return dp[row][state] = res;
	}
}

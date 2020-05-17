import java.util.ArrayList;
import java.util.List;

public class _1434NumberofWaystoWearDifferentHatstoEachOther {
	public int M = 1000000007;
	public int end = 0;
	public int numberWays(List<List<Integer>> hats) {
		if (null == hats || hats.size() == 0) return 0;
		int n = hats.size();
		Integer[][] dp = new Integer[40][(1 << n)];
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 40; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < hats.size(); i++) {
			for (int j = 0; j < hats.get(i).size(); j++) {
				adj.get(hats.get(i).get(j) - 1).add(i);
			}
		}
		end = (1 << n) - 1;
		return dfs(hats, 0, 0, dp, adj);
	}

	private int dfs(List<List<Integer>> hats, int idx, int status, Integer[][] dp, List<List<Integer>> adj) {
		if (status == end) return 1;
		if (idx == 40) return 0;
		if (dp[idx][status] != null) return dp[idx][status];
		int res = 0;
		res = (res + dfs(hats, idx + 1, status, dp, adj)) % M;
		for (int i : adj.get(idx)) {
			if (((status >> i) & 1) == 0) {
				res = (res + dfs(hats, idx + 1, status | (1 << i), dp, adj)) % M;
			}
		}
		dp[idx][status] = res;
		return res;
	}
}

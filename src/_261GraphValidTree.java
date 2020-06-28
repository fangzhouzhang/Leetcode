import java.util.ArrayList;
import java.util.List;

public class _261GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
		for (int[] e: edges) {
			int u = e[0];
			int v = e[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		boolean[] visit = new boolean[n];
		if (dfs(adj, 0, -1, visit)) return false;
		for (int i = 0; i < n; i++) {
			if (!visit[i]) return false;
		}
		return true;
	}

	private boolean dfs(List<List<Integer>> adj, int cur, int pre, boolean[] visit) {
		visit[cur] = true;
		for (int i = 0; i < adj.get(cur).size(); i++) {
			int next = adj.get(cur).get(i);
			if ((visit[next] && pre != next) || (!visit[next] && dfs(adj, next, cur, visit))) return true;
		}
		return false;
	}
}

import java.util.ArrayList;
import java.util.List;

public class _1192CriticalConnectionsinaNetwork {
	private int R;
	private int C;
	private List<Integer>[] adj;
	private boolean[] visit;
	private int[] ord;
	private int[] low;
	private int id;
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> res = new ArrayList<>();
		if (connections == null) return res;
		adj = new List[n];
		visit = new boolean[n];
		ord = new int[n];
		low = new int[n];
		id = 0;
		for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
		for (List<Integer> connection : connections) {
			adj[connection.get(0)].add(connection.get(1));
			adj[connection.get(1)].add(connection.get(0));
		}
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				dfs(i, i, res);
			}
		}
		return res;
	}

	private void dfs(int v, int parent, List<List<Integer>> res) {
		visit[v] = true;
		ord[v] = id;
		low[v] = id;
		id++;
		for (int w : adj[v]) {
			if (!visit[w]) {
				dfs(w, v, res);
				low[v] = Math.min(low[v], low[w]);
				if (low[w] > ord[v]) {
					List<Integer> edge = new ArrayList<>();
					edge.add(v);
					edge.add(w);
					res.add(edge);
				}
			} else if (w != parent) {
				low[v] = Math.min(low[v], low[w]);
			}
		}
	}
}

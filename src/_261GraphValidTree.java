import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _261GraphValidTree {
	private int[] visit;
	private int R;
	private int C;
	private List<Integer>[] g;
	public boolean validTree(int n, int[][] edges) {
		if (n - 1 != edges.length) return false;
		visit = new int[n];
		Arrays.fill(visit, -1);
		g = new List[n];
		for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
		for (int[] e : edges) {
			g[e[0]].add(e[1]);
			g[e[1]].add(e[0]);
		}
		for (int i = 0; i < n; i++) {
			if (visit[i] == -1 && dfs(i, i)) {
				boolean cc = true;
				for (int j = 0; j < n; j++) {
					if (visit[j] != 0) {
						cc = false;
						break;
					}
				}
				if (cc) return true;
				Arrays.fill(visit, -1);
			}

		}
		return false;
	}

	private boolean dfs(int v, int parent) {
		visit[v] = 0;
		for (int w : g[v]) {
			if (visit[w] == -1) {
				if (!dfs(w, v)) {
					visit[v] = -1;
					return false;
				}
			}
			else if (w != parent) {
				visit[v] = -1;
				return false;
			}
		}
		return true;
	}
}

import java.util.Arrays;

public class _785IsGraphBipartite {
	public boolean isBipartite(int[][] graph) {
		if (graph == null || graph.length == 0) return true;
		int n = graph.length;
		int[] color = new int[n];
		Arrays.fill(color, -1);
		for (int i = 0; i < n; i++)
			if (color[i] == -1)
				if (!dfs(i, graph, color, 0))
					return false;
		return true;
	}

	private boolean dfs(int v, int[][] g, int[] color, int c) {
		color[v] = c;
		for (int w : g[v]) {
			if (color[w] == -1) {
				if (!dfs(w, g, color, c == 0 ? 1 : 0)) return false;
			} else {
				if (color[w] == c) return false;
			}
		}
		return true;
	}
}

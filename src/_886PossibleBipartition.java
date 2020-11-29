import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _886PossibleBipartition {
	private int[] color;
	private List<Integer>[] g;
	public boolean possibleBipartition(int N, int[][] dislikes) {
		color = new int[N + 1];
		Arrays.fill(color, -1);
		g = new List[N + 1];
		for (int i = 1; i < N + 1; i++) g[i] = new ArrayList<>();
		for (int[] d: dislikes) {
			g[d[0]].add(d[1]);
			g[d[1]].add(d[0]);
		}
		for (int i = 1; i < N + 1; i++) {
			if (color[i] == -1 && !dfs(i, 0)) return false;
		}
		return true;
	}

	private boolean dfs(int cur, int c) {
		color[cur] = c;
		for (int w : g[cur]) {
			if (color[w] == -1) {
				if (!dfs(w, 1 - c)) return false;
			} else {
				if (color[w] == c) return false;
			}
		}
		return true;
	}
}

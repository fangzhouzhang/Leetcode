import java.util.HashSet;
import java.util.Set;

public class _1761MinimumDegreeofaConnectedTrioinaGraph {
	public int minTrioDegree(int n, int[][] edges) {
		Set<Integer>[] g = new Set[n + 1];
		for (int i = 0; i < n + 1; i++) g[i] = new HashSet<>();
		for (int[] e : edges) {
			g[e[0]].add(e[1]);
			g[e[1]].add(e[0]);
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n + 1; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				for (int k = j + 1; k < n + 1; k++) {
					if (g[i].contains(j) && g[i].contains(k) && g[j].contains(i) && g[j].contains(k) && g[k].contains(i) && g[k].contains(j)) {
						res = Math.min(res, g[i].size() + g[j].size() + g[k].size() - 6);
					}
				}
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}

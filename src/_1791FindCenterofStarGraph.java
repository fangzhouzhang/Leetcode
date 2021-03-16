import java.util.ArrayList;
import java.util.List;

public class _1791FindCenterofStarGraph {
	public int findCenter(int[][] edges) {
		if (edges == null || edges.length == 0) return 0;
		int n = edges.length;
		List<Integer>[] g = new List[n + 2];
		for (int i = 0; i <= n + 1; i++) g[i] = new ArrayList<>();
		for (int[] e : edges) {
			g[e[0]].add(e[1]);
			g[e[1]].add(e[0]);
		}
		for (int i = 0; i <= n + 1; i++) {
			if (g[i].size() == n) return i;
		}
		return -1;
	}
}

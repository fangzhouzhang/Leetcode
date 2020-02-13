import java.util.ArrayList;
import java.util.List;

public class _802FindEventualSafeStates {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> res = new ArrayList<>();
		if (graph == null || graph.length == 0) return res;
		Boolean[] isSafe = new Boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (graph[i].length == 0) isSafe[i] = true;
		}
		for (int i = 0; i < graph.length; i++) {
			if (isSafeNode(i, graph, isSafe, new boolean[graph.length])) res.add(i);
		}
		return res;
	}

	private boolean isSafeNode(int i, int[][] g, Boolean[] isSafe, boolean[] visit) {
		if (isSafe[i] != null) return isSafe[i];
		visit[i] = true;
		for (int k = 0; k < g[i].length; k++) {
			if (visit[g[i][k]] || !isSafeNode(g[i][k], g, isSafe, visit)) {
				isSafe[i] = false;
				return false;
			}
		}
		visit[i] = false;
		isSafe[i] = true;
		return true;
	}
}

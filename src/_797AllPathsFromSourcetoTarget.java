import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _797AllPathsFromSourcetoTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		if (graph == null || graph.length == 0) return res;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < graph.length; i++) {
			map.put(i, new HashSet<>());
			for (int nei: graph[i]) {
				map.get(i).add(nei);
			}
		}
		List<Integer> path = new ArrayList<Integer>();
		path.add(0);
		dfs(map, 0, path, res, graph.length - 1);
		return res;
	}

	private void dfs(Map<Integer, Set<Integer>> map, int cur, List<Integer> path, List<List<Integer>> res, int n) {
		if (cur == n) {
			res.add(new ArrayList<>(path));
			return;
		}
		Set<Integer> neis = map.get(cur);
		if (neis == null || neis.size() == 0) return;
		for (Integer nei: neis) {
			path.add(nei);
			dfs(map, nei, path, res, n);
			path.remove(path.size() - 1);
		}
	}
}

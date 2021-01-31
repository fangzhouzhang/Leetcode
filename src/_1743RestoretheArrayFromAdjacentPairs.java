import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1743RestoretheArrayFromAdjacentPairs {
	int idx = 0;
	public int[] restoreArray(int[][] adjacentPairs) {
		if (adjacentPairs == null || adjacentPairs.length == 0) return new int[0];
		int n = adjacentPairs.length;
		int[] res = new int[n + 1];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] p : adjacentPairs) {
			if (!map.containsKey(p[0])) map.put(p[0], new ArrayList<>());
			map.get(p[0]).add(p[1]);
			if (!map.containsKey(p[1])) map.put(p[1], new ArrayList<>());
			map.get(p[1]).add(p[0]);
		}
		int head = 0;
		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			if (e.getValue().size() == 1) {
				head = e.getKey();
				break;
			}
		}
		Set<Integer> set = new HashSet<>();
		dfs(head, map, set, res);
		return res;
	}

	private void dfs(int head, Map<Integer, List<Integer>> map, Set<Integer> set, int[] res) {
		set.add(head);
		res[idx++] = head;
		for (int nei : map.get(head)) {
			if (set.contains(nei)) continue;
			dfs(nei, map, set, res);
		}
	}
}

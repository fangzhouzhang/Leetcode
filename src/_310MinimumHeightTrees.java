import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _310MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res = new ArrayList<>();
		if (edges == null) return res;
		if (edges.length == 0) {
			for (int i = 0; i < n; i++) {
				res.add(i);
			}
			return res;
		}
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] edge: edges) {
			int e0 = edge[0];
			int e1 = edge[1];
			if (!map.containsKey(e0)) map.put(e0, new HashSet<>());
			if (!map.containsKey(e1)) map.put(e1, new HashSet<>());
			map.get(e0).add(e1);
			map.get(e1).add(e0);
		}
		List<Integer> leaves = new ArrayList<>();
		for (Map.Entry<Integer, Set<Integer>> e: map.entrySet()) {
			if (e.getValue().size() == 1) leaves.add(e.getKey());
		}
		while (n > 2) {
			int size = leaves.size();
			List<Integer> tmp = new ArrayList<>();
			for (int leaf: leaves) {
				Set<Integer> neis = map.get(leaf);
				if (neis == null) continue;
				for (Integer nei : neis) {
					if (map.get(nei) == null) continue;
					map.get(nei).remove(leaf);
					if (map.get(nei).size() == 1) tmp.add(nei);
				}
			}
			leaves = tmp;
			n -= size;
		}
		return leaves;
	}
}

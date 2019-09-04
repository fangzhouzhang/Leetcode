import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) {
			List<Integer> leaves = new ArrayList<>();
			leaves.add(0);
			return leaves;
		}
		List<Set<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new HashSet<Integer>());
		}
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < adj.size(); i++) {
			if (adj.get(i).size() == 1) {
				leaves.add(i);
			}
		}
		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int leaf: leaves) {
				Set<Integer> set = adj.get(leaf);
				for (Integer num : set) {
					adj.get(num).remove(leaf);
					if (adj.get(num).size() == 1) {
						newLeaves.add(num);
					}
				}

			}
			leaves = newLeaves;
		}
		return leaves;
	}
}

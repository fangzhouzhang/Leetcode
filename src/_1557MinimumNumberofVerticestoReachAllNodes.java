import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1557MinimumNumberofVerticestoReachAllNodes {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		List<Integer> res = new ArrayList<>();
		if (edges == null) return res;
		Set<Integer> set = new HashSet<>();
		for (List<Integer> edge : edges) {
			set.add(edge.get(1));
		}
		for (int i = 0; i < n; i++) {
			if (!set.contains(i)) res.add(i);
		}
		return res;
	}
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedundantConnection {
	/**
	 * time: o(n^2) space: o(n)
	 * @param edges
	 * @return
	 */
	public int[] findRedundantConnection(int[][] edges) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] edge: edges) {
			int cur = edge[0];
			int dest = edge[1];
			//traverse all edge neighbors, find there is a way to go back to original point
			Set<Integer> dedup = new HashSet<>();
			if (!isValidTree(edge, map, cur, dest, dedup)) {
				return edge;
			}
			addEdgeToMap(edge, map);
		}
		return null;//not find
	}
	private boolean isValidTree(int[] edge,
								Map<Integer, Set<Integer>> map,
								int cur,
								int dest,
								Set<Integer> dedup) {
		if (cur == dest) {// it is a circle linked tree
			return false;
		}
		dedup.add(cur);//starting from cur
		Set<Integer> neighbors = map.get(cur);
		if (neighbors == null) {
			return true;
		}
		for (Integer neigh: neighbors) {
			if (dedup.contains(neigh)) {
				continue;
			}
			if (!isValidTree(edge, map, neigh, dest, dedup)) {
				return false;
			}
		}
		return true;
	}
	private void addEdgeToMap(int[] edge, Map<Integer, Set<Integer>> map) {
		for (int i = 0; i < edge.length; i++) {
			if (map.containsKey(edge[i])) {
				Set<Integer> neighbors = map.get(edge[i]);
				neighbors.add(edge[edge.length - 1 - i]);
			} else {
				Set<Integer> neighbors = new HashSet<>();
				neighbors.add(edge[edge.length - 1 - i]);
				map.put(edge[i], neighbors);
			}
		}
	}
}

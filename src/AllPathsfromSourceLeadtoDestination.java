import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsfromSourceLeadtoDestination {
	private int UNPROCESS = 0;
	private int PROCESSING = 1;
	private int PROCESSED = 2;
	public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
		if (edges.length == 0 || edges[0].length == 0) {
			return true;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] status = new int[n];
		buildGraph(map, edges);
		return dfs(map, status, source, destination);
	}

	private boolean dfs(Map<Integer, List<Integer>> map, int[] status, int source, int destination) {
		if (source == destination && map.get(source) == null) {
			return true;
		}
		status[source] = PROCESSING;
		if (map.get(source) == null) {
			return false;
		}
		for (Integer in : map.get(source)) {
			if (status[in] == PROCESSING) {
				//System.out.println("in is " + in);
				return false;
			}
			if (!dfs(map, status, in, destination)) {
				//System.out.println("blocked in " + in);
				return false;
			}
		}

		status[source] = PROCESSED;
		return true;
	}

	private void buildGraph(Map<Integer, List<Integer>> map, int[][] edges) {
		for (int[] edge: edges) {
			int out = edge[0];
			int in = edge[1];
			if (map.containsKey(out)) {
				List<Integer> list = map.get(out);
				list.add(in);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(in);
				map.put(out, list);
			}
		}
	}
}

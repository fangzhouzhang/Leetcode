import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _332ReconstructItinerary {
	private final String START = "JFK";
	public List<String> findItinerary(List<List<String>> tickets) {
		LinkedList<String> res = new LinkedList<>();
		if (tickets == null || tickets.size() == 0) return res;
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> t : tickets) {
			String from = t.get(0);
			String to = t.get(1);
			if (!map.containsKey(from)) map.put(from, new PriorityQueue<String>());
			map.get(from).add(to);
		}
		dfs(map, START, res);
		return res;
	}

	private void dfs(
			Map<String, PriorityQueue<String>> map,
			String cur,
			LinkedList<String> res) {
		PriorityQueue<String> pq = map.get(cur);
		while (pq != null && !pq.isEmpty()) {
			String next = pq.poll();
			dfs(map, next, res);
		}
		res.addFirst(cur);
	}
}

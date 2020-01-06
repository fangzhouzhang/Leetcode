import java.util.*;

public class _332ReconstructItinerary {
	private final String START = "JFK";
	public List<String> findItinerary(List<List<String>> tickets) {
		LinkedList<String> res = new LinkedList<>();
		if (tickets == null || tickets.size() == 0) return res;
		Map<String, PriorityQueue<String>> map = buildGraph(tickets);
		dfs(map, res, START);
		return res;
	}

	private void dfs(Map<String, PriorityQueue<String>> map, LinkedList<String> res, String cur) {
		PriorityQueue<String> children = map.get(cur);
		while (children != null && children.size() != 0) {
			String to = children.poll();
			dfs(map, res, to);
		}
		res.add(0, cur);
	}

	private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> ticket : tickets) {
			if (!map.containsKey(ticket.get(0))) map.put(ticket.get(0), new PriorityQueue<String>());
			map.get(ticket.get(0)).add(ticket.get(1));
		}
		return map;
	}
}

import java.util.*;

public class _133CloneGraph {
	public Node cloneGraph(Node node) {
		if (node == null) return null;
		Map<Node, Node> map = new HashMap<>();
		bfs(map, node);
		copyNeighbors(map);
		return map.get(node);
	}

	private void copyNeighbors(Map<Node, Node> map) {
		for (Map.Entry<Node, Node> e : map.entrySet()) {
			Node origin = e.getKey();
			Node copy = e.getValue();
			for (Node nei : origin.neighbors) {
				copy.neighbors.add(map.get(nei));
			}
		}
	}

	private void bfs(Map<Node, Node> map, Node node) {
		Queue<Node> q = new LinkedList<>();
		Set<Node> set = new HashSet<>();
		q.add(node);
		set.add(node);
		while (!q.isEmpty()) {
			Node n = q.poll();
			map.put(n, new Node(n.val, new ArrayList<Node>()));
			if (n.neighbors == null) continue;
			for (Node nei: n.neighbors) {
				if (!set.contains(nei)) {
					set.add(nei);
					q.add(nei);
				}
			}
		}
	}

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {}

		public Node(int _val,List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}

		public Node(int _val) {
			val = _val;
		}
	};
}

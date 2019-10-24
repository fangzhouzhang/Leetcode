import java.util.*;

public class CloneGraph {
	public Node cloneGraph(Node node) {
		if (node == null) return null;
		Map<Node, Node> map = getMap(node);
		copy(map);
		return map.get(node);
	}

	private Map<Node, Node> getMap(Node node) {
		Queue<Node> q = new LinkedList<>();
		Set<Node> set = new HashSet<>();
		Map<Node, Node> map = new HashMap<>();
		q.add(node);
		while (!q.isEmpty()) {
			Node np = q.poll();
			Node n = new Node(np.val);
			map.put(np, n);
			for (Node nei: np.neighbors) {
				if (!set.contains(nei)) {
					set.add(nei);
					q.add(nei);
				}
			}
		}
		return map;
	}

	private void copy(Map<Node, Node> map) {
		for (Map.Entry<Node, Node> e : map.entrySet()) {
			Node origin = e.getKey();
			Node copy = e.getValue();
			if (copy.neighbors == null) {
				copy.neighbors = new ArrayList<>();
			}
			for (Node n : origin.neighbors) {
				copy.neighbors.add(map.get(n));
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
	};
}

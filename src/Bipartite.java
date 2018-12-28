import java.util.*;

public class Bipartite {
	public boolean isBipartite(List<GraphNode> graph) {
		// write your solution here
		Queue<GraphNode> queue = new LinkedList<>();
		Set<GraphNode> dedup = new HashSet<>();
		Set<GraphNode> set0 = new HashSet<>();
		Set<GraphNode> set1 = new HashSet<>();
		int count = 0;
		queue.add(graph.get(0));
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				GraphNode node = queue.poll();
				dedup.add(node);
				if (count % 2 == 0) {
					set0.add(node);
					for (GraphNode nei : node.neighbors) {
						set1.add(nei);
						if (!dedup.contains(nei)) {
							queue.add(nei);
						}
					}
				} else {
					set1.add(node);
					for (GraphNode nei : node.neighbors) {
						set0.add(nei);
						if (!dedup.contains(nei)) {
							queue.add(nei);
						}
					}
				}
			}
			count++;
		}
		for (GraphNode node : set0) {
			if (set1.contains(node)) {
				return false;
			}
		}
		return true;
	}
	class GraphNode {
		public int key;
		public List<GraphNode> neighbors;
		public GraphNode(int key) {
			this.key = key;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}
	public boolean isBipartite(int[][] graph) {
		if (graph == null || graph.length == 0) {
			return true;
		}
		Queue<Integer> q = new LinkedList<>();
		Integer[] color = new Integer[graph.length];
		Set<Integer> set = new HashSet<>();
		boolean[] isValid = new boolean[1];
		isValid[0] = true;
		while (set.size() < graph.length && isValid[0] == true) {
			addVertex(graph, q, set);
			traverseGraph(q, set, color, isValid, graph);
		}

		return isValid[0];
	}
	private void addVertex(int[][] graph,
						   Queue<Integer> q,
						   Set<Integer> set) {
		for (int i = 0; i < graph.length; i++) {
			if (set.add(i)) {
				q.add(i);
				return;
			}
		}
	}
	private void traverseGraph(Queue<Integer> q,
							   Set<Integer> set,
							   Integer[] color,
							   boolean[] isValid,
							   int[][] graph ) {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int vertex = q.poll();
				if (color[vertex] == null) {
					color[vertex] = 1;
				}
				for (int neighbor: graph[vertex]) {
					if (color[neighbor] == null) {
						color[neighbor] = color[vertex] * -1;
					} else if (color[neighbor] != color[vertex] * -1) {//color[neighbor] != null

						isValid[0] = false;
						return;
					}
					if (set.add(neighbor)) {
						q.add(neighbor);
					}
				}
			}
		}
	}
}


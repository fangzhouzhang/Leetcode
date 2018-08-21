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
}
class GraphNode {
   public int key;
   public List<GraphNode> neighbors;
   public GraphNode(int key) {
     this.key = key;
     this.neighbors = new ArrayList<GraphNode>();
   }
 }

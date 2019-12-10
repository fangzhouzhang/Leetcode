import java.util.*;

public class _210CourseScheduleII {
	/**
	 * time: o(v + e) e [v, v^2]
	 * 
	 */
	private final int INIT = 0;
	private final int VISITING = 1;
	private final int VISITED = 2;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses < 0) return new int[0];
		int[] res = new int[numCourses];
		if (prerequisites == null || prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) res[i] = i;
		}
		Node[] nodes = new Node[numCourses];
		for (int i = 0; i < numCourses; i++) nodes[i] = new Node(i);
		for (int[] p : prerequisites) {
			nodes[p[1]].neighbors.add(nodes[p[0]]);
		}
		int[] idx = new int[1];
		idx[0] = numCourses - 1;
		for (Node n : nodes) {
			if (containCycle(n, idx, res)) return new int[0];
		}
		return res;
	}

	private boolean containCycle(Node node, int[] idx, int[] res) {
		if (node.status == VISITING) return true;
		if (node.status == VISITED) return false;
		node.status = VISITING;
		for (Node n : node.neighbors) {
			if (containCycle(n, idx, res)) return true;
		}
		node.status = VISITED;
		res[idx[0]] = node.val;
		idx[0]--;
		return false;
	}

	private class Node {
		int val;
		int status;
		Set<Node> neighbors;
		public Node(int val) {
			this.val = val;
			status = INIT;
			neighbors = new HashSet<>();
		}
	}
}

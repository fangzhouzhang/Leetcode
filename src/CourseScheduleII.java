import java.util.*;

public class CourseScheduleII {
	/**
	 * time: o(v + e) e [v, v^2]
	 * 
	 */
	private final int INIT = 0;
	private final int VISITING = 1;
	private final int VISITED = 2;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		if (prerequisites == null || prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				res[i] = i;
			}
			return res;
		}
		Node[] courses = new Node[numCourses];
		for (int i = 0; i < numCourses; i++) {
			courses[i] = new Node(i);
		}
		for (int[] pre : prerequisites) {
			courses[pre[1]].nexts.add(courses[pre[0]]);
		}
		int[] idx = new int[1];
		idx[0] = numCourses - 1;
		for (Node node: courses) {
			if (cycle(node, res, idx)) {
				return new int[0];
			}
		}
		return res;
	}
	private boolean cycle(Node node, int[] res, int[] idx) {
		if (node.status == VISITING) {
			return true;
		}
		if (node.status == VISITED) {
			return false;
		}
		node.status = VISITING;
		for (Node next: node.nexts) {
			if (cycle(next, res, idx)) {
				return true;
			}
		}
		res[idx[0]] = node.key;
		idx[0]--;
		node.status = VISITED;
		return false;
	}
	private class Node {
		private int key;
		private int status;
		private List<Node> nexts;
		public Node(int key) {
			status = INIT;
			this.key = key;
			nexts = new ArrayList<>();
		}
	}
}

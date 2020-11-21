import java.util.Comparator;
import java.util.PriorityQueue;

public class _1102PathWithMaximumMinimumValue {
	int min = Integer.MAX_VALUE;
	private boolean[][] visit;
	private int R;
	private int C;
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int maximumMinimumPath(int[][] A) {
		if (A == null || A.length == 0) return 0;
		R = A.length;
		C = A[0].length;
		visit = new boolean[R][C];
		PriorityQueue<Node> pq = new PriorityQueue<>(new MyComparator());
		pq.add(new Node(0, 0, A[0][0]));
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (visit[node.x][node.y]) continue;
			visit[node.x][node.y] = true;
			if (node.x == R - 1 && node.y == C - 1) {
				return node.val;
			}
			for (int[] dir : dirs) {
				int nextx = node.x + dir[0];
				int nexty = node.y + dir[1];
				if (nextx < 0 || nextx >= R || nexty < 0 || nexty >= C) continue;
				if (visit[nextx][nexty]) continue;
				pq.add(new Node(nextx, nexty, Math.min(A[nextx][nexty], node.val)));
			}
		}
		return -1;
	}

	private class MyComparator implements Comparator<Node> {
		public int compare(Node a, Node b) {
			return b.val - a.val;
		}
	}

	private class Node {
		int x;
		int y;
		int val;
		public Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
	/**
	 * @param matrix: List[List[int]]
	 * @param k: a integer
	 * @return: return a integer
	 * time: o(k * logk) space: o(k)
	 */

	public int kthSmallest(int[][] matrix, int k) {
		// write your code here
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>(k, new NodeComp());
		pq.add(new Node(matrix[0][0], 0, 0));
		int count = 0;
		boolean[][] visit = new boolean[matrix.length][matrix[0].length];
		visit[0][0] = true;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			count++;
			if (count == k) {
				return node.val;
			}
			if (node.row < matrix.length && node.col + 1 < matrix[0].length && visit[node.row][node.col + 1] == false) {
				pq.add(new Node(matrix[node.row][node.col + 1], node.row, node.col + 1));
				visit[node.row][node.col + 1] = true;
			}
			if (node.row + 1 < matrix.length && node.col < matrix[0].length && visit[node.row + 1][node.col] == false) {
				pq.add(new Node(matrix[node.row + 1][node.col], node.row + 1, node.col));
				visit[node.row + 1][node.col] = true;
			}
		}
		return -1;
	}
	private class Node {
		int val;
		int row;
		int col;
		public Node(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
	}
	private class NodeComp implements Comparator<Node> {
		@Override
		public int compare(Node n1, Node n2) {
			return n1.val - n2.val;
		}
	}
}



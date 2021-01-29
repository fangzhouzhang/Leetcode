import java.util.PriorityQueue;

public class _1738FindKthLargestXORCoordinateValue {
	public int kthLargestValue(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] mat = new int[m][n];
		for (int i = 0; i < m; i++) {
			int x = matrix[i][0];
			mat[i][0] = x;
			for (int j = 1; j < n; j++) {
				x ^= matrix[i][j];
				mat[i][j] = x;
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int j = 0; j < n; j++) {
			int x = mat[0][j];
			if (pq.size() >= k) {
				if (pq.peek() < x) {
					pq.poll();
					pq.add(x);
				}
			} else {
				pq.add(x);
			}
			for (int i = 1; i < m; i++) {
				x ^= mat[i][j];
				if (pq.size() >= k) {
					if (pq.peek() < x) {
						pq.poll();
						pq.add(x);
					}
				} else {
					pq.add(x);
				}
			}
		}
		return pq.peek();
	}
}

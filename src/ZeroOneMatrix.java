import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
	private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[0][0];
		}
		int[][] res = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					continue;
				}
				bfs(matrix, i, j, new LinkedList<Integer>(), res, new boolean[matrix.length][matrix[0].length]);
			}
		}
		return res;
	}
	private void bfs(int[][] matrix,
					 int i,
					 int j,
					 Queue<Integer> q,
					 int[][] res,
					 boolean[][] visit) {
		q.add(i * matrix[0].length + j);
		visit[i][j] = true;
		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				Integer num = q.poll();
				int row = num / matrix[0].length;
				int col = num % matrix[0].length;
				for (int[] dir: dirs) {
					if (isValid(matrix, visit, row + dir[0], col + dir[1])) {
						q.add((row + dir[0]) * matrix[0].length + (col + dir[1]));
						visit[row + dir[0]][col + dir[1]] = true;
					}
				}
				if (matrix[row][col] == 1) {

				} else {//matrix[row][col] == 0
					res[i][j] = step;
					return;
				}
			}
			step++;
		}
	}
	private boolean isValid(int[][] matrix, boolean[][] visit, int i, int j) {
		if (i < 0 || i >= matrix.length) {
			return false;
		}
		if (j < 0 || j >= matrix[0].length) {
			return false;
		}

		if (visit[i][j] == true) {
			return false;
		}
		return true;
	}
}

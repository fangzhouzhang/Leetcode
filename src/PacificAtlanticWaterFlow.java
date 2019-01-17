import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
	private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				bfs(new LinkedList<>(),
						new boolean[matrix.length][matrix[0].length],
						matrix,
						i,
						j,
						res);
			}
		}
		return res;
	}
	private void bfs(Queue<Integer> q,
					 boolean[][] visit,
					 int[][] matrix,
					 int i,
					 int j,
					 List<int[]> res) {
		q.add(i * matrix[0].length + j);
		visit[i][j] = true;
		boolean reachP = false;
		boolean reachA = false;
		while (!q.isEmpty()) {
			Integer val = q.poll();
			int row = val / matrix[0].length;
			int col = val % matrix[0].length;
			for (int[] dir : dirs) {
				if (isValid(matrix, visit, row + dir[0], col + dir[1], matrix[row][col])) {
					q.add((row + dir[0]) * matrix[0].length + (col + dir[1]));
					visit[row + dir[0]][col + dir[1]] = true;
				}
			}
			if (row == 0 || col == 0) {
				reachP = true;
			}
			if (row == matrix.length - 1 || col == matrix[0].length - 1) {
				reachA = true;
			}
			if (reachP == true && reachA == true) {
				int[] coord = new int[2];
				coord[0] = i;
				coord[1] = j;
				res.add(coord);
				return;
			}
		}
	}
	private boolean isValid(int[][] matrix, boolean[][] visit, int i, int j, int target) {
		if (i < 0 || i >= matrix.length) {
			return false;
		}
		if (j < 0 || j >= matrix[0].length) {
			return false;
		}
		if (matrix[i][j] > target) {
			return false;
		}
		if (visit[i][j] == true) {
			return false;
		}
		return true;
	}
}

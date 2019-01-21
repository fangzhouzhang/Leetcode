public class LongestIncreasingPathinaMatrix {
	private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int[][] mem = new int[matrix.length][matrix[0].length];
		boolean[][] visit = new boolean[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				visit[i][j] = true;
				max = Math.max(max, dfs(matrix, visit, mem, i, j));
				visit[i][j] = false;
			}
		}
		return max;
	}
	private int dfs(int[][] matrix,
					boolean[][] visit,
					int[][] mem,
					int i,
					int j) {
		if (mem[i][j] != 0) {
			return mem[i][j];
		}
		//have not explore mem[i][j] yet
		int max = 0;
		for (int[] dir: dirs) {
			if (isValid(matrix, visit, i + dir[0], j + dir[1], matrix[i][j])) {
				visit[i + dir[0]][j + dir[1]] = true;
				max = Math.max(max, dfs(matrix, visit, mem, i + dir[0], j + dir[1]));
				visit[i + dir[0]][j + dir[1]] = false;
			}
		}
		mem[i][j] = max + 1;
		return max + 1;
	}
	private boolean isValid(int[][] matrix, boolean[][] visit, int i, int j, int target) {
		if (i < 0 || i >= matrix.length) {
			return false;
		}
		if (j < 0 || j >= matrix[0].length) {
			return false;
		}
		if (visit[i][j] == true) {
			return false;
		}
		if (matrix[i][j] <= target) {
			return false;
		}
		return true;
	}
}

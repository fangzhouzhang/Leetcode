public class _1706WhereWilltheBallFall {
	int R = 0;
	int C = 0;
	public int[] findBall(int[][] grid) {
		if (grid == null || grid.length == 0) return new int[0];
		R = grid.length;
		C = grid[0].length;
		int[] res = new int[C];
		for (int i = 0; i < C; i++) {
			res[i] = dfs(grid, 0, i, res);
		}
		return res;
	}

	private int dfs(int[][] grid, int row, int col, int[] res) {
		if (row == R) return col;
		if (grid[row][col] == 1) {
			if (col + 1 == C || grid[row][col + 1] == -1) {
				return -1;
			}
			return dfs(grid, row + 1, col + 1, res);

		} else {
			if (col - 1 == -1 || grid[row][col - 1] == 1) {
				return -1;
			}
			return dfs(grid, row + 1, col - 1, res);
		}
	}
}

public class _695MaxAreaofIsland {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	private int R;
	private int C;
	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		R = grid.length;
		C = grid[0].length;
		boolean[][] visit = new boolean[R][C];
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 0 || visit[i][j]) continue;
				res = Math.max(res, dfs(i, j, grid, visit));
			}
		}
		return res;
	}

	private int dfs(int row, int col, int[][] grid, boolean[][] visit) {
		visit[row][col] = true;
		int res = 1;
		for (int[] dir : dirs) {
			int r = row + dir[0];
			int c = col + dir[1];
			if (!inbound(grid, r, c) || grid[r][c] != 1 || visit[r][c]) continue;
			res += dfs(r, c, grid, visit);
		}
		return res;
	}

	private boolean inbound(int[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length) {
			return false;
		}
		if (col < 0 || col >= grid[0].length) {
			return false;
		}
		return true;
	}
}

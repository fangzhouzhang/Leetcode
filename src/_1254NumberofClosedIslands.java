public class _1254NumberofClosedIslands {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	private int R;
	private int C;
	public int closedIsland(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		R = grid.length;
		C = grid[0].length;
		boolean[][] visit = new boolean[R][C];
		for (int c = 0; c < C; c++) {
			if (!visit[0][c] && grid[0][c] == 0) {
				dfs(0, c, grid, visit);
			}
			if (!visit[R - 1][c] && grid[R - 1][c] == 0) {
				dfs(R - 1, c, grid, visit);
			}
		}
		for (int r = 0; r < R; r++) {
			if (!visit[r][0] && grid[r][0] == 0) {
				dfs(r, 0, grid, visit);
			}
			if (!visit[r][C - 1] && grid[r][C - 1] == 0) {
				dfs(r, C - 1, grid, visit);
			}
		}
		int res = 0;
		for (int r = 1; r < R - 1; r++) {
			for (int c = 1; c < C - 1; c++) {
				if (!visit[r][c] && grid[r][c] == 0) {
					dfs(r, c, grid, visit);
					res++;
				}
			}
		}
		return res;
	}

	private void dfs(int row, int col, int[][] grid, boolean[][] visit) {
		visit[row][col] = true;
		grid[row][col] = 1;
		for (int[] dir : dirs) {
			int r = row + dir[0];
			int c = col + dir[1];
			if (!inbound(grid, r, c) || grid[r][c] != 0 || visit[r][c]) continue;
			dfs(r, c, grid, visit);
		}
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

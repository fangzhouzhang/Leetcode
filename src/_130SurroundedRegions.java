public class _130SurroundedRegions {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	private int R;
	private int C;
	public void solve(char[][] grid) {
		if (grid == null || grid.length == 0) return;
		R = grid.length;
		C = grid[0].length;
		boolean[][] visit = new boolean[R][C];
		for (int c = 0; c < C; c++) {
			if (!visit[0][c] && grid[0][c] == 'O') {
				dfs(0, c, grid, visit);
			}
			if (!visit[R - 1][c] && grid[R - 1][c] == 'O') {
				dfs(R - 1, c, grid, visit);
			}
		}
		for (int r = 0; r < R; r++) {
			if (!visit[r][0] && grid[r][0] == 'O') {
				dfs(r, 0, grid, visit);
			}
			if (!visit[r][C - 1] && grid[r][C - 1] == 'O') {
				dfs(r, C - 1, grid, visit);
			}
		}
		for (int r = 1; r < R - 1; r++) {
			for (int c = 1; c < C - 1; c++) {
				if (grid[r][c] == 'O' && !visit[r][c]) grid[r][c] = 'X';
			}
		}
	}

	private void dfs(int row, int col, char[][] grid, boolean[][] visit) {
		visit[row][col] = true;
		for (int[] dir : dirs) {
			int r = row + dir[0];
			int c = col + dir[1];
			if (!inbound(r, c) || grid[r][c] == 'X' || visit[r][c]) continue;
			dfs(r, c, grid, visit);
		}
	}

	private boolean inbound(int row, int col) {
		if (row < 0 || row >= R) {
			return false;
		}
		if (col < 0 || col >= C) {
			return false;
		}
		return true;
	}
}

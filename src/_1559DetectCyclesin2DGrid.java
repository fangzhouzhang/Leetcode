public class _1559DetectCyclesin2DGrid {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public boolean containsCycle(char[][] grid) {
		if (grid == null || grid.length == 0) return false;
		int n = grid.length, m = grid[0].length;
		boolean[][] v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!v[i][j]) {
					v[i][j] = true;
					if (dfs(grid, -1, -1, i, j, v)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] grid, int oldr, int oldc, int r, int c, boolean[][] v) {
		char cur = grid[r][c];
		for (int[] dir : dirs) {
			int newr = r + dir[0];
			int newc = c + dir[1];
			if (!inbound(grid, newr, newc)) continue;
			if (newr == oldr && newc == oldc) continue;
			if (grid[newr][newc] != cur) continue;
			if (v[newr][newc]) return true;
			v[newr][newc] = true;
			if (dfs(grid, r, c, newr, newc, v)) return true;
		}
		return false;
	}

	private boolean inbound(char[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length) {
			return false;
		}
		if (col < 0 || col >= grid[0].length) {
			return false;
		}
		return true;
	}
}

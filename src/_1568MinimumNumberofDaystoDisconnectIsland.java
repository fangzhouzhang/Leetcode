public class _1568MinimumNumberofDaystoDisconnectIsland {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int minDays(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		int num = findIsland(grid);
		if (num > 1) return 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					grid[i][j] = 0;
					if (findIsland(grid) > 1) return 1;
					grid[i][j] = 1;
				}
			}
		}
		return 2;
	}

	private int findIsland(int[][] g) {
		boolean[][] v = new boolean[g.length][g[0].length];
		int res = 0;
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				if (g[i][j] == 1 && !v[i][j]) {
					res++;
					if (res > 1) return 2;
					dfs(g, v, i, j);
				}
			}
		}
		return res;

	}

	private void dfs(int[][] g, boolean[][] v, int row, int col) {
		for (int[] dir : dirs) {
			int r = row + dir[0];
			int c = col + dir[1];
			if (!inbound(g, r, c)) continue;
			if (g[r][c] == 0) continue;
			if (v[r][c]) continue;
			v[r][c] = true;
			dfs(g, v, r, c);
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

public class _200NumberofIslands {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) return 0;

		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					res++;
				}
			}
		}
		return res;
	}

	private void dfs(char[][] g, int row, int col) {
		g[row][col] = '#';


		for (int[] dir : dirs) {
			int r = row + dir[0];
			int c = col + dir[1];
			if (inbound(g, r, c) && g[r][c] == '1') dfs(g, r, c);
		}
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

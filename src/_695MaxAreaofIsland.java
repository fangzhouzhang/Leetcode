public class _695MaxAreaofIsland {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) max = Math.max(max, dfs(grid, i, j));
			}
		}
		return max;
	}

	private int dfs(int[][] grid, int i, int j) {
		if (grid[i][j] == -1 || grid[i][j] == 0) return 0;
		grid[i][j] = -1;
		int sum = 0;
		for (int[] dir : dirs) {
			if (inbound(grid, i + dir[0], j + dir[1])) {
				sum += dfs(grid, i + dir[0], j + dir[1]);
			}
		}
		return sum + 1;
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

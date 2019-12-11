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

	private void dfs(char[][] grid, int row, int col) {
		grid[row][col] = '#';
		for (int[] dir : dirs) {
			int newRow = dir[0] + row;
			int newCol = dir[1] + col;
			if (isValid(grid, newRow, newCol) && grid[newRow][newCol] == '1') dfs(grid, newRow, newCol);
		}
	}

	private boolean isValid(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length) return false;
		if (j < 0 || j >= board[i].length) return false;
		if (board[i][j] == '#') return false;
		return true;
	}
}

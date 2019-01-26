public class UniquePathsIII {
	private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	private final int START = 1;
	private final int END = 2;
	private final int OBSTACLE = -1;
	private final int EMPTY = 0;
	public int uniquePathsIII(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int remain = getRemain(grid);
		// System.out.println("remain is " + remain);
		int[] res = new int[1];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == START) {
					dfs(grid, new boolean[grid.length][grid[0].length], remain, i, j, res);
				}
			}
		}

		return res[0];
	}
	private void dfs(int[][] grid, boolean[][] visit, int remain, int row, int col, int[] res) {
		if (grid[row][col] == END && remain == 0) {
			res[0]++;
			return;
		}
		if (grid[row][col] == END && remain != 0) {
			// System.out.println("finish is " + remain);
			return;
		}
		for (int[] dir : dirs) {
			if (isValid(grid, visit, row + dir[0], col + dir[1])) {
				visit[row + dir[0]][col + dir[1]] = true;
				if (grid[row + dir[0]][col + dir[1]] == EMPTY) {
					// System.out.println("EMPTY is " + remain + " " + grid[row + dir[0]][col + dir[1]]);
					dfs(grid, visit, remain - 1, row + dir[0], col + dir[1], res);
				} else {
					// System.out.println("END is " + remain + " " + grid[row + dir[0]][col + dir[1]]);
					dfs(grid, visit, remain, row + dir[0], col + dir[1], res);
				}
				visit[row + dir[0]][col + dir[1]] = false;
			}
		}
	}
	private boolean isValid(int[][] grid, boolean[][] visit, int row, int col) {
		if (row < 0 || row >= grid.length) {
			return false;
		}
		if (col < 0 || col >= grid[0].length) {
			return false;
		}
		if (grid[row][col] == START || grid[row][col] == OBSTACLE) {
			return false;
		}
		if (visit[row][col] == true) {
			return false;
		}
		return true;
	}
	private int getRemain(int[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == EMPTY) {
					res++;
				}
			}
		}
		return res;
	}
}

public class TheMaze {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		if (maze.length == 0 || maze[0].length == 0) {
			return false;
		}
		Boolean[][] dp = new Boolean[maze.length][maze[0].length];
		return dfs(maze, start[0], start[1], destination, dp);
	}

	private boolean dfs(int[][] maze, int row, int col, int[] destination, Boolean[][] dp) {
		if (row == destination[0] && col == destination[1]) {
			return true;
		}
		if (dp[row][col] != null) {
			return dp[row][col];
		}
		maze[row][col] = -1;
		for (int[] dir : dirs) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];
			if (!inbound(maze, newRow, newCol)) {
				continue;
			}
			while (inbound(maze, newRow, newCol) && maze[newRow][newCol] != 1) {
				newRow += dir[0];
				newCol += dir[1];
			}
			newRow -= dir[0];
			newCol -= dir[1];
			if (maze[newRow][newCol] != -1) {
				if (dfs(maze, newRow, newCol, destination, dp)) {
					dp[row][col] = true;
					return true;
				}
			}
		}
		dp[row][col] = false;
		return false;
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

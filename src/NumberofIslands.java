public class NumberofIslands {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public final char WATER = '0';
	public final char LAND = '1';
	private int res = 0;

	/**
	 * grid has row rows, has col columns.
	 * time: o(row * col * 4^(row + col)) space: o(row * col)
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		boolean[][] visit = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (visit[i][j] == false && grid[i][j] == LAND) {
					search(grid, visit, i, j);//mark visited island
					res++;
				}
			}
		}
		return res;
	}
	private void search(char[][] grid, boolean[][] visit, int row, int col) {
		if (grid[row][col] == WATER) {
			return;
		}
		visit[row][col] = true;
		for (int[] dir : dirs) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];
			if (inbound(grid, newRow, newCol) && visit[newRow][newCol] == false) {
				search(grid, visit, newRow, newCol);
			}
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

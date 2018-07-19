public class MinimumPathSum {
	/**
	 * @param grid: a list of lists of integers
	 * @return: An integer, minimizes the sum of all numbers along its path
	 * time:o(n^2) space:o(n)
	 */
	public int minPathSum(int[][] grid) {
		// write your code here
		if (grid.length == 0 || grid[0].length == 0) {
			return -1;
		}
		//m[i][j] means mini length from grid[i][j] to reach final coordinate
		int row = grid.length;
		int col = grid[0].length;
		int[][] m = new int[row][col];
		//base case

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (i == row - 1 && j == col - 1) {
					m[i][j] = grid[i][j];
					continue;
				}
				int right = (isValid(grid, i, j + 1) == true) ? m[i][j + 1] : Integer.MAX_VALUE;
				int down = (isValid(grid, i + 1, j) == true) ? m[i + 1][j] : Integer.MAX_VALUE;
				m[i][j] = grid[i][j] + Math.min(right, down);

			}
		}
		return m[0][0];
	}
	public boolean isValid(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length) {
			return false;
		}
		if (j < 0 || j >= grid[i].length) {
			return false;
		}
		return true;
	}
}

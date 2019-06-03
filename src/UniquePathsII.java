public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		Integer[][] mem = new Integer[obstacleGrid.length][obstacleGrid[0].length];
		return dfs(obstacleGrid, 0, 0, mem);
	}
	private int dfs(int[][] ob, int i, int j, Integer[][] mem) {
		if (i == ob.length - 1 && j == ob[0].length - 1 && ob[i][j] != 1) {
			return 1;
		}

		if (i == ob.length || j == ob[0].length) {
			return 0;
		}

		if (mem[i][j] != null) {
			return mem[i][j];
		}

		int sum = 0;
		//move right
		if (isValid(ob, i, j + 1)) {
			sum += dfs(ob, i, j + 1, mem);
		}
		//move down
		if (isValid(ob, i + 1, j)) {
			sum += dfs(ob, i + 1, j, mem);
		}
		mem[i][j] = sum;
		return sum;
	}
	private boolean isValid(int[][] a, int i, int j) {
		if (i < 0 || i >= a.length) {
			return false;
		}
		if (j < 0 || j >= a[0].length) {
			return false;
		}
		if (a[i][j] == 1) {
			return false;
		}
		return true;
	}
}

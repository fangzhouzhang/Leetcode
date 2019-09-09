public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int max = 0;
		int rowCnt = 0;
		int[] colCnt = new int[grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// int rowCnt = 0;
				if (j == 0 || grid[i][j - 1] == 'W') {
					rowCnt = 0;
					int k = j;
					while (k < grid[i].length && grid[i][k] != 'W') {
						rowCnt += grid[i][k] == 'E' ? 1 : 0;
						k++;
					}
				}
				if (i == 0 || grid[i - 1][j] == 'W') {
					colCnt[j] = 0;
					int k = i;
					while (k < grid.length && grid[k][j] != 'W') {
						colCnt[j] += grid[k][j] == 'E' ? 1 : 0;
						k++;
					}
				}
				if (grid[i][j] == '0') {
					max = Math.max(max, rowCnt + colCnt[j]);
				}
			}
		}
		return max;
	}
}

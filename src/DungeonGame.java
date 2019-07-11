public class DungeonGame {
	private int[][] dirs = {{1, 0}, {0, 1}};
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon.length == 0 || dungeon[0].length == 0)  {
			return 0;
		}
		int[][] cache = new int[dungeon.length][dungeon[0].length];

		return dfs(cache, dungeon, 0, 0);
	}
	//return min health a knight is needed
	private int dfs(int[][] cache, int[][] dungeon, int row, int col) {
		if (row == dungeon.length - 1 && col == dungeon[0].length - 1) {
			return dungeon[row][col] >= 0 ? 1 : 1 - dungeon[row][col];
		}
		if (cache[row][col] != 0) {
			return cache[row][col];
		}

		int min = Integer.MAX_VALUE;
		for (int[] dir : dirs) {
			if (isValid(dungeon, row + dir[0], col + dir[1])) {
				int requiredHP = dfs(cache, dungeon, row + dir[0], col + dir[1]);
				int cur = 0;
				if (requiredHP > dungeon[row][col]) {
					cur = requiredHP - dungeon[row][col];
				} else {
					cur = 1;
				}
				min = Math.min(min, cur);

			}
		}
		cache[row][col] = min;
		return min;
	}
	private boolean isValid(int[][] dungeon, int i, int j) {
		if (i < 0 || i >= dungeon.length) {
			return false;
		}
		if (j < 0 || j >= dungeon[0].length) {
			return false;
		}
		return true;
	}
}

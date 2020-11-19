public class _980UniquePathsIII {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	private int R;
	private int C;
	private int start;
	private int end;
	private int left;
	private boolean[][] visit;
	private int[][] grid;
	public int uniquePathsIII(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		R = grid.length;
		C = grid[0].length;
		this.grid = grid;
		visit = new boolean[R][C];
		left = R * C;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (grid[r][c] == 1) {
					start = r * C + c;
					grid[r][c] = 0;
				} else if (grid[r][c] == 2) {
					end = r * C + c;
					grid[r][c] = 0;
				} else if (grid[r][c] == -1) left--;
			}
		}
		return dfs(start);
	}

	private int dfs(int cur) {
		int x = cur / C;
		int y = cur % C;
		visit[x][y] = true;
		left--;
		if (cur == end && left == 0) {
			visit[x][y] = false;
			left++;
			return 1;
		}
		int res = 0;
		for (int[] dir : dirs) {
			int nextx = x + dir[0];
			int nexty = y + dir[1];
			if (nextx < 0 || nextx >= R || nexty < 0 || nexty >= C) continue;
			if (grid[nextx][nexty] == -1) continue;
			if (visit[nextx][nexty]) continue;
			res += dfs(nextx * C + nexty);
		}
		visit[x][y] = false;
		left++;
		return res;
	}
}

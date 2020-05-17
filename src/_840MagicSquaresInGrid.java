public class _840MagicSquaresInGrid {
	public int numMagicSquaresInside(int[][] grid) {
		int res = 0;
		int rows = grid.length;
		if (0 == rows) return 0;
		int cols = grid[0].length;
		if (0 == cols) return 0;
		for (int i = 0; i < rows - 2; i++) {
			for (int j = 0; j < cols - 2; j++) {
				boolean[] rs = new boolean[10];
				boolean[] cs = new boolean[10];
				boolean[] d = new boolean[10];
				if (grid[i][j] <= 0 || grid[i][j] >= 10) continue;
				if (rs[grid[i][j]] || cs[grid[i][j]]) continue;
				rs[grid[i][j]] = true;
				cs[grid[i][j]] = true;

				if (grid[i][j + 1] <= 0 || grid[i][j + 1] >= 10) continue;
				if (rs[grid[i][j + 1]] || cs[grid[i][j + 1]]) continue;
				rs[grid[i][j + 1]] = true;
				cs[grid[i][j + 1]] = true;

				if (grid[i][j + 2] <= 0 || grid[i][j + 2] >= 10) continue;
				if (rs[grid[i][j + 2]] || cs[grid[i][j + 2]]) continue;
				rs[grid[i][j + 2]] = true;
				cs[grid[i][j + 2]] = true;

				if (grid[i + 1][j] <= 0 || grid[i + 1][j] >= 10) continue;
				if (rs[grid[i + 1][j]] || cs[grid[i + 1][j]]) continue;
				rs[grid[i + 1][j]] = true;
				cs[grid[i + 1][j]] = true;

				if (grid[i + 1][j + 1] <= 0 || grid[i + 1][j + 1] >= 10) continue;
				if (rs[grid[i + 1][j + 1]] || cs[grid[i + 1][j + 1]]) continue;
				rs[grid[i + 1][j + 1]] = true;
				cs[grid[i + 1][j + 1]] = true;

				if (grid[i + 1][j + 2] <= 0 || grid[i + 1][j + 2] >= 10) continue;
				if (rs[grid[i + 1][j + 2]] || cs[grid[i + 1][j + 2]]) continue;
				rs[grid[i + 1][j + 2]] = true;
				cs[grid[i + 1][j + 2]] = true;

				if (grid[i + 2][j] <= 0 || grid[i + 2][j] >= 10) continue;
				if (rs[grid[i + 2][j]] || cs[grid[i + 2][j]]) continue;
				rs[grid[i + 2][j]] = true;
				cs[grid[i + 2][j]] = true;

				if (grid[i + 2][j + 1] <= 0 || grid[i + 2][j + 1] >= 10) continue;
				if (rs[grid[i + 2][j + 1]] || cs[grid[i + 2][j + 1]]) continue;
				rs[grid[i + 2][j + 1]] = true;
				cs[grid[i + 2][j + 1]] = true;

				if (grid[i + 2][j + 2] <= 0 || grid[i + 2][j + 2] >= 10) continue;
				if (rs[grid[i + 2][j + 2]] || cs[grid[i + 2][j + 2]]) continue;
				rs[grid[i + 2][j + 2]] = true;
				cs[grid[i + 2][j + 2]] = true;

				int s1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
				int s2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
				int s3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];

				int s4 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
				int s5 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
				int s6 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];


				int s7 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
				int s8 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];

				if (s1 != s2 || s2 != s3 || s1 != s3) continue;
				if (s4 != s5 || s5 != s6 || s4 != s6) continue;
				if (s7 != s8) continue;
				if (s1 != s4 || s4 != s7 || s1 != s7) continue;
				res++;

			}
		}
		return res;
	}
}

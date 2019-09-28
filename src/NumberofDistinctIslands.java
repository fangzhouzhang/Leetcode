import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	private char[] chars = {'l', 'r', 'd', 'u'};
	public int numDistinctIslands(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) return 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					dfs(grid, i, j, set, sb);
					set.add(new String(sb));
				}
			}
		}
		return set.size();
	}

	private void dfs(int[][] grid, int i, int j, Set<String> set, StringBuilder sb) {
		grid[i][j] = 0;
		for (int k = 0; k < dirs.length; k++) {
			if (!inbound(grid, i + dirs[k][0], j + dirs[k][1]) || grid[i + dirs[k][0]][j + dirs[k][1]] == 0) continue;
			sb.append(chars[k]);
			if (set.contains(new String(sb))) {
				sb.deleteCharAt(sb.length() - 1);
				continue;
			}
			dfs(grid,  i + dirs[k][0], j + dirs[k][1], set, sb);
			/**
			 WARNING: DO NOT FORGET to add path for backtracking, otherwise, we may have same result when we count two
			 * distinct islands in some cases
			 *
			 * eg:              1 1 1   and    1 1 0
			 *                  0 1 0          0 1 1
			 * with b:          rdbr           rdr
			 * without b:       rdr            rdr
			 **/
			sb.append("b");
		}
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

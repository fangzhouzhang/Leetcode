import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _317ShortestDistancefromAllBuildings {
	private final int LAND = 0;
	private final int BUILDING = 1;
	private final int OBSTACLE = 2;
	private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
		int m = grid.length;
		int n = grid[0].length;
		int[][] buildReach = new int[m][n];
		int[][] dist = new int[m][n];
		int totalBuildings = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == BUILDING) {
					bfs(grid, i, j, buildReach, dist);
					totalBuildings++;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (buildReach[i][j] == totalBuildings && grid[i][j] == LAND) min = Math.min(min, dist[i][j]);
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private void bfs(int[][] grid, int i, int j, int[][] buildReach, int[][] dist) {
		int n = grid[0].length;
		Set<Integer> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		int d = 1;
		q.add(i * n + j);
		set.add(i * n + j);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int val = q.poll();
				int row = val / n;
				int col = val % n;
				buildReach[row][col]++;
				dist[row][col] += d;
				for (int[] dir : dirs) {
					int newRow = row + dir[0];
					int newCol = col + dir[1];
					if (isValid(grid, newRow, newCol) && !set.contains(newRow * n + newCol)) {
						set.add(newRow * n + newCol);
						q.add(newRow * n + newCol);
					}
				}
			}
			d++;
		}
	}

	private boolean isValid(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length) return false;
		if (j < 0 || j >= grid[0].length) return false;
		if (grid[i][j] == BUILDING || grid[i][j] == OBSTACLE) return false;
		return true;
	}
}

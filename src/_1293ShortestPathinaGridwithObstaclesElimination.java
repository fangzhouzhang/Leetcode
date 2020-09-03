import java.util.LinkedList;
import java.util.Queue;

public class _1293ShortestPathinaGridwithObstaclesElimination {
	private static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int shortestPath(int[][] grid, int k) {
		if (grid == null || grid.length == 0) return 0;
		int n = grid.length, m = grid[0].length;
		boolean[][][] v = new boolean[n][m][k + 1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0, 0, 0});
		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int r = arr[0];
				int c = arr[1];
				int o = arr[2];
				if (r == n - 1 && c == m - 1) return step;
				for (int[] dir : dirs) {
					int rr = r + dir[0];
					int cc = c + dir[1];
					if (rr < 0 || rr >= n) continue;
					if (cc < 0 || cc >= m) continue;
					int oo = o + grid[rr][cc];
					if (oo > k) continue;
					if (v[rr][cc][oo]) continue;
					v[rr][cc][oo] = true;
					q.add(new int[]{rr,cc,oo});
				}
			}
			step++;
		}
		return -1;
	}
}

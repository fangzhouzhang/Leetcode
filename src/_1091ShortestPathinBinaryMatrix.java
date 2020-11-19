import java.util.LinkedList;
import java.util.Queue;

public class _1091ShortestPathinBinaryMatrix {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
	private int R;
	private int C;
	public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		R = grid.length;
		C = grid[0].length;
		boolean[][] visit = new boolean[R][C];
		if (grid[0][0] == 1) return -1;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visit[0][0] = true;
		int step = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int p = q.poll();
				int x = p / C;
				int y = p % C;
				if (x == R - 1 && y == C - 1) return step;
				for (int[] dir : dirs) {
					int nextx = x + dir[0];
					int nexty = y + dir[1];
					if (!inbound(nextx, nexty) || grid[nextx][nexty] == 1 || visit[nextx][nexty]) continue;
					q.add(nextx * C + nexty);
					visit[nextx][nexty] = true;
				}
			}
			step++;
		}
		return -1;
	}

	private boolean inbound(int row, int col) {
		if (row < 0 || row >= R) {
			return false;
		}
		if (col < 0 || col >= C) {
			return false;
		}
		return true;
	}
}

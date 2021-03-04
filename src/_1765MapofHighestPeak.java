import java.util.LinkedList;
import java.util.Queue;

public class _1765MapofHighestPeak {
	private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public int[][] highestPeak(int[][] isWater) {
		Queue<int[]> q = new LinkedList<>();
		int n = isWater.length, m = isWater[0].length;
		int[][] res = new int[n][m];
		for (int i = 0; i < isWater.length; i++) {
			for (int j = 0; j < isWater[i].length; j++) {
				if (isWater[i][j] == 1) {
					int[] arr = {i, j, 0};
					q.add(arr);
					isWater[i][j] = -1;
				}
			}
		}
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				res[cur[0]][cur[1]] = cur[2];
				for (int[] dir : dirs) {
					int xx = cur[0] + dir[0];
					int yy = cur[1] + dir[1];
					int dis = cur[2] + 1;
					if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
					if (isWater[xx][yy] == -1) continue;
					int[] arr = {xx, yy, dis};
					q.add(arr);
					isWater[xx][yy] = -1;
				}
			}
		}
		return res;
	}
}

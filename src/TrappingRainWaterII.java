import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {
	private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public int trapRainWater(int[][] heightMap) {
		if (heightMap.length == 0 || heightMap[0].length == 0) {
			return 0;
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());
		//add outside of array to pq
		boolean[][] visit = new boolean[heightMap.length][heightMap[0].length];
		for (int i = 0; i < heightMap.length; i++) {
			for (int j = 0; j < heightMap[i].length; j++) {
				if (i == 0 || i == heightMap.length - 1 || j == 0 || j == heightMap[i].length - 1) {
					pq.add(new Pair(i, j, heightMap[i][j]));
					visit[i][j] = true;
				}
			}
		}

		int water = 0;
		int max = 0;
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			if (p.val > max) {
				max = p.val;
			}
			for (int[] dir : dirs) {
				int row = p.row + dir[0];
				int col = p.col + dir[1];
				if (valid(visit, row, col)) {
					if (max > heightMap[row][col]) {
						water += max - heightMap[row][col];
					}
					pq.add(new Pair(row, col, heightMap[row][col]));
					visit[row][col] = true;
				}
			}
		}
		return water;
	}

	private boolean valid(boolean[][] v, int i, int j) {
		if (i < 0 || i >= v.length) {
			return false;
		}
		if (j < 0 || j >= v[i].length) {
			return false;
		}
		if (v[i][j]) {
			return false;
		}
		return true;
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return a.val - b.val;
		}
	}

	private class Pair {
		public int row;
		public int col;
		public int val;
		public Pair(int r, int c, int v) {
			row = r;
			col = c;
			val = v;
		}
	}
}

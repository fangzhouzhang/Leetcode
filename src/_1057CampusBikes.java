import java.util.ArrayList;
import java.util.List;

public class _1057CampusBikes {
	public int[] assignBikes(int[][] workers, int[][] bikes) {
		if (workers == null || bikes == null) return null;
		int n = workers.length, m = bikes.length;
		int[] res = new int[n];
		List<List<int[]>> list = new ArrayList<>(2001);
		for (int i = 0; i < 2001; i++) list.add(new ArrayList<>());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int dist = getDistance(workers, i, bikes, j);
				list.get(dist).add(new int[]{i, j});
			}
		}

		boolean[] usedWorker = new boolean[n];
		boolean[] usedBike = new boolean[m];

		for (List<int[]> l : list) {
			for (int[] p : l) {
				if (!usedWorker[p[0]] && !usedBike[p[1]]) {
					res[p[0]] = p[1];
					usedWorker[p[0]] = true;
					usedBike[p[1]] = true;
				}
			}
		}
		return res;
	}

	private int getDistance(int[][] workers, int i, int[][] bikes, int j) {
		return Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
	}
}

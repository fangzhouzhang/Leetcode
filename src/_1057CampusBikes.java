import java.util.ArrayList;
import java.util.List;

public class _1057CampusBikes {
	public int[] assignBikes(int[][] workers, int[][] bikes) {
		if (workers == null || workers.length == 0 || bikes == null || bikes.length == 0) return new int[0];
		int n = workers.length, m = bikes.length;
		List[] distances = new List[2001];
		for (int i = 0; i < 2001; i++) distances[i] = new ArrayList<int[]>();
		boolean[] assignWorkers = new boolean[n];
		boolean[] assignBikes = new boolean[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int dis = getDistance(workers[i], bikes[j]);
				distances[dis].add(new int[]{i, j});
			}
		}
		int[] res = new int[n];
		for (int i = 0; i < 2001; i++) {
			List<int[]> list = distances[i];
			if (list == null) continue;
			for (int[] pair : list) {
				if (!assignWorkers[pair[0]] && !assignBikes[pair[1]]) {
					assignWorkers[pair[0]] = true;
					assignBikes[pair[1]] = true;
					res[pair[0]] = pair[1];
				}
			}
		}
		return res;
	}

	private int getDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}

import java.util.ArrayList;
import java.util.List;

public class CampusBikes {
	public int[] assignBikes(int[][] workers, int[][] bikes) {
		int n = workers.length;
		int m = bikes.length;
		int[] res = new int[n];
		boolean[] a_w = new boolean[n];
		boolean[] a_b = new boolean[m];
		//max dist = 2000, need index 2000
		List<int[]>[] buckets = new List[2001];
		// Arrays.fill(buckets, new ArrayList<int[]>());
		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int dist = getDistance(workers[i], bikes[j]);
				if (buckets[dist] == null) buckets[dist] = new ArrayList<>();
				buckets[dist].add(new int[]{i, j});
			}
		}
		for (int i = 0; i < 2001; i++) {
			List<int[]> list = buckets[i];
			if (list == null) continue;
			for (int[] b : list) {
				if (!a_w[b[0]] && !a_b[b[1]]) {
					res[b[0]] = b[1];
					a_w[b[0]] = true;
					a_b[b[1]] = true;
				}
			}
		}
		return res;
	}

	private int getDistance(int[] w, int[] b) {
		return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
	}
}

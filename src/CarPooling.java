import java.util.Arrays;
import java.util.Comparator;

public class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
		//edge corner case
		if (trips == null || trips.length == 0) return false;
		int[][] starts = new int[trips.length][3];
		int[][] ends = new int[trips.length][3];
		Arrays.sort(trips, new StartComparator());
		for (int i = 0; i < trips.length; i++) {
			starts[i][0] = trips[i][0];
			starts[i][1] = trips[i][1];
			starts[i][2] = trips[i][2];
		}
		Arrays.sort(trips, new EndComparator());
		int cur = 0;
		int i = 0, j = 0;
		while (i < starts.length && j < trips.length) {
			if (starts[i][1] < trips[j][2]) {
				cur += starts[i][0];
				if (cur > capacity) return false;
				i++;
			} else {
				cur -= trips[j][0];
				j++;
			}
		}
		return true;
	}

	private class StartComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[1] - b[1];
		}
	}

	private class EndComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[2] - b[2];
		}
	}
}

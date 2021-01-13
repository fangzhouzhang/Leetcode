import java.util.Arrays;
import java.util.Comparator;

public class _1710MaximumUnitsonaTruck {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, new MyComparator());
		int res = 0;
		for (int[] b : boxTypes) {
			if (truckSize >= b[0]) {
				res += b[1] * b[0];
				truckSize -= b[0];
			} else {
				res += truckSize * b[1];
				break;
			}
		}
		return res;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return b[1] - a[1];
		}
	}
}

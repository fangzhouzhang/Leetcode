import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class QueueReconstructionbyHeight {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new MyComparator());
		LinkedList<int[]> list = new LinkedList<>();
		for (int[] p : people) {
			list.add(p[1], p);
		}
		int n = people.length;
		return list.toArray(new int[n][2]);
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
		}
	}
}

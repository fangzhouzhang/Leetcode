import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _1341TheKWeakestRowsinaMatrix {
	public int[] kWeakestRows(int[][] mat, int k) {
		if (mat == null || mat.length == 0) return new int[0];
		//count ones in each line, write a comparator to sort, according to frequency of
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			int sum = 0;
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1) sum++;
			}
			list.add(new Pair(sum, i));
		}
		Collections.sort(list, new MyComparator());
		int[] res = new int[k];
		for (int i = 0; i < k; i++) res[i] = list.get(i).idx;
		return res;
	}

	private class Pair {
		int ones;
		int idx;
		public Pair(int ones, int idx) {
			this.ones = ones;
			this.idx = idx;
		}
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			if (a.ones != b.ones) return a.ones - b.ones;
			else return a.idx - b.idx;
		}
	}
}

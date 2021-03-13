import java.util.Arrays;
import java.util.Comparator;

public class _506RelativeRanks {
	public String[] findRelativeRanks(int[] score) {
		if (score == null || score.length == 0) return new String[0];
		int n = score.length;
		String[] res = new String[n];
		Pair[] ps = new Pair[n];
		for (int i = 0; i < n; i++) {
			ps[i] = new Pair(score[i], i);
		}
		Arrays.sort(ps, new MyComp());
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				res[ps[i].idx] = "Gold Medal";
			} else if (i == 1) {
				res[ps[i].idx] = "Silver Medal";
			} else if (i == 2) {
				res[ps[i].idx] = "Bronze Medal";
			} else {
				res[ps[i].idx] = (i + 1) + "";
			}
		}
		return res;
	}

	private class Pair {
		int key;
		int idx;
		public Pair(int key, int idx) {
			this.key = key;
			this.idx = idx;
		}
	}

	private class MyComp implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return b.key - a.key;
		}
	}
}

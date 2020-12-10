import java.util.Arrays;
import java.util.Comparator;

public class _406QueueReconstructionbyHeight {
	int[] tree;

	private int lowbit(int x) {
		return x & (-x);
	}

	private void add(int idx, int val) {
		for (int i = idx; i < tree.length; i += lowbit(i)) tree[i] += val;
	}

	private int query(int idx) {
		int sum = 0;
		for (int i = idx; i > 0; i -= lowbit(i)) sum += tree[i];
		return sum;
	}

	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0) return new int[0][0];
		int n = people.length;
		tree = new int[n + 1];
		int[][] res = new int[n][2];
		Arrays.sort(people, new MyComparator());
		for (int[] p : people) {
			int l = 1, r = n;
			while (l < r) {
				int mid = l + r >> 1;
				if (mid - query(mid) < p[1] + 1) l = mid + 1;
				else r = mid;
			}
			res[l - 1] = p;
			add(l, 1);
		}
		return res;
	}

	private class MyComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
		}
	}
}

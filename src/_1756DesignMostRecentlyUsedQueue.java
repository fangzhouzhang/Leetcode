public class _1756DesignMostRecentlyUsedQueue {
	private class MRUQueue {
		int[] tree;
		int[] arr;
		int cnt = 0;
		int n = 0;
		public MRUQueue(int n) {
			this.n = n;
			tree = new int[n + 1 + 2000];
			arr = new int[n + 1 + 2000];
			for (int i = 1; i <= n; i++) update(i, 1);
			for (int i = 1; i <= n; i++) arr[i] = i;
		}

		public int fetch(int k) {
			//find the 1st position which sum of tree is k
			int l = 1, r = tree.length - 1;
			while (l < r) {
				int mid = l + r >> 1;
				if (query(mid) >= k) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			// current l is the first position which has exact k elements
			int res = arr[l];
			arr[l] = 0;
			arr[n + 1 + cnt] = res;
			update(l, -1);
			update(n + 1 + cnt, 1);
			cnt++;
			return res;
		}

		private void update(int idx, int val) {
			for (int i = idx; i < tree.length; i += lowbit(i)) {
				tree[i] += val;
			}
		}

		private int query(int idx) {
			int sum = 0;
			for (int i = idx; i > 0; i -= lowbit(i)) {
				sum += tree[i];
			}
			return sum;
		}

		private int lowbit(int x) {
			return x & (-x);
		}
	}
}

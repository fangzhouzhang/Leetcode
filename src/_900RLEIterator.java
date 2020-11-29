public class _900RLEIterator {
	private class RLEIterator {
		private int[] a;
		private int idx; // next pointing idx

		public RLEIterator(int[] A) {
			idx = 0;
			a = A;
		}

		public int next(int n) {
			while (idx < a.length && a[idx] < n) {
				n -= a[idx];
				idx += 2;
			}
			if (idx + 1>= a.length) return -1;
			a[idx] -= n;
			return a[idx + 1];
		}
	}
}

public class _1231DivideChocolate {
	public int maximizeSweetness(int[] sweetness, int K) {
		if (null == sweetness) return 0;
		int n = sweetness.length;
		if (0 == n) return 0;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += sweetness[i - 1];
		}
		int end = sum / (K + 1);
		int start = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (check(sweetness, K + 1, mid)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end;
	}

	private boolean check(int[] a, int k, int sum) {
		int s = 0;
		for (int i = 0; i < a.length; i++ ) {
			s += a[i];
			if (s >= sum) {
				s = 0;
				k--;
				if (k == 0) break;
			}
		}
		return k == 0;
	}
}

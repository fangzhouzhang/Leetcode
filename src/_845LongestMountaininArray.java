public class _845LongestMountaininArray {
	public int longestMountain(int[] A) {
		int n = A.length;
		if (0 == n) return 0;
		int[] d1 = new int[n];
		int[] d2 = new int[n];
		d1[0] = 1;
		d2[n - 1] = 1;
		boolean change = false;
		for (int i = 1; i < n; i++) {
			if (A[i - 1] < A[i]) d1[i] += d1[i - 1] + 1;
			else {
				d1[i] = 1;
				change = true;
			}
		}
		if (!change) return 0;
		change = false;
		for (int i = n - 2; i >= 0; i--) {
			if (A[i + 1] < A[i]) d2[i] += d2[i + 1] + 1;
			else {
				d2[i] = 1;
				change = true;
			}
		}
		if (!change) return 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0 || i == n - 1 || (A[i - 1] != A[i] && A[i] != A[i + 1]))
				res = Math.max(res, d1[i] + d2[i] - 1);
		}
		return res >= 3 ? res : 0;
	}
}

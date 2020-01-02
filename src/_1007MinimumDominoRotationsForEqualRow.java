public class _1007MinimumDominoRotationsForEqualRow {
	public int minDominoRotations(int[] A, int[] B) {
		int a = Math.min(getMin(A[0], A, B), getMin(A[0], B, A));
		int b = Math.min(getMin(B[0], A, B), getMin(B[0], B, A));
		int res = Math.min(a, b);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private int getMin(int target, int[] a, int[] b) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != target) {
				if (b[i] == target) count++;
				else return Integer.MAX_VALUE;
			}
		}
		return count;
	}
}

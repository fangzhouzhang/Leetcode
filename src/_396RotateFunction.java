public class _396RotateFunction {
	public int maxRotateFunction(int[] A) {
		if (A == null || A.length == 0) return 0;
		int max = Integer.MIN_VALUE, sum = 0, prev = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			prev += i * A[i];
		}
		max = prev;
		for (int i = 1; i < A.length; i++) {
			prev += sum - A.length * A[A.length - i];
			max = Math.max(max, prev);
		}
		return max;
	}
}

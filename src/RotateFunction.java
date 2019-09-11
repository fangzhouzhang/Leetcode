public class RotateFunction {
	public int maxRotateFunction(int[] A) {
		int sum = 0;
		int prev = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			prev += i * A[i];
		}
		int max = prev;
		for (int i = A.length - 1; i >= 1; i--) {
			prev += sum - A.length * A[i];
			max = Math.max(max, prev);
		}
		return max;
	}
}

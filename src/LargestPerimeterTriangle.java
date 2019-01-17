import java.util.Arrays;

public class LargestPerimeterTriangle {
	public int largestPerimeter(int[] A) {
		if (A == null || A.length < 3) {
			return 0;
		}
		int max = 0;
		Arrays.sort(A);
		for (int i = A.length - 1; i >= 2; i--) {
			for (int j = i - 1; j >= 1; j--) {
				for (int k = j - 1; k >= 0; k--) {
					if (isValid(A, i, j, k)) {
						// System.out.println(A[i] + " " + A[j] + " " +  A[k]);
						max = Math.max(max, A[i] + A[j] + A[k]);
						return max;
					}
				}
			}
		}
		return max;
	}
	private boolean isValid(int[] a, int i, int j, int k) {
		if (a[i] + a[j] <= a[k] || a[i] + a[k] <= a[j] || a[j] + a[k] <= a[i]) {
			return false;
		}
		if (Math.abs(a[i] - a[j]) >= a[k] ||
				Math.abs(a[i] - a[k]) >= a[j] ||
				Math.abs(a[j] - a[k]) >= a[i]) {
			return false;
		}
		return true;
	}
}

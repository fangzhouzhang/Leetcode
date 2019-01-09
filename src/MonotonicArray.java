public class MonotonicArray {
	public boolean isMonotonic(int[] A) {
		if (A == null) {
			return false;
		}
		if (A.length < 2) {
			return true;
		}
		Integer trend = null;
		for (int i = 1; i < A.length; i++) {
			if (trend == null) {
				if (A[i] > A[i - 1]) {
					trend = 1;
				} else if (A[i] < A[i - 1]) {
					trend = -1;
				}
			} else {
				if (trend == 1 && A[i] < A[i - 1]) {
					return false;
				}
				if (trend == -1 && A[i] > A[i - 1]) {
					return false;
				}
			}
		}
		return true;
	}
}

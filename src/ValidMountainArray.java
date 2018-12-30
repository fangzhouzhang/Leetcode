public class ValidMountainArray {
	public boolean validMountainArray(int[] A) {
		if (A.length < 3) {
			return false;
		}


		boolean hasInc = false;
		boolean hasDec = false;

		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] == A[i]) {
				return false;
			} else if (A[i - 1] < A[i] && hasDec == true) {
				return false;
			} else if (A[i - 1] > A[i] && hasInc == false) {
				return false;
			} else if (A[i - 1] < A[i] && hasDec == false) {
				hasInc = true;
			} else if (A[i - 1] > A[i] && hasInc == true) {
				hasDec = true;
			}
		}
		if (hasDec == false) {
			return false;
		}
		return true;
	}
}

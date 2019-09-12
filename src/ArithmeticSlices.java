public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] A) {
		if (A.length <= 2) {
			return 0;
		}
		int count = 0;
		int sum = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				count++;
			} else {
				sum += count * (count + 1) / 2;
				count = 0;
			}
		}
		return sum += count * (count + 1) / 2;
	}
}

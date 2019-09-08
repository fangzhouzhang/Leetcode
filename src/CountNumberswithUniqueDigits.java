public class CountNumberswithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		int res = 0;
		for (int i = 1; i <= n; i++) {
			res += count(i);
		}
		return res;
	}

	private int count(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 10;
		}
		int res = 1;
		for (int i = 9; i >= (11 - n); i--) {
			res *= i;
		}
		return 9 * res;
	}
}

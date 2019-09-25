public class ConsecutiveNumbersSum {
	public int consecutiveNumbersSum(int N) {
		int res = 0;
		for (int k = 1; k <= (int) Math.sqrt(2 * N); k++) {
			if (2 * N % k == 0) {
				int x = 2 * N / k - (k + 1);
				if (x % 2 == 0 && x >= 0) {
					res++;
				}
			}
		}
		return res;
	}
}

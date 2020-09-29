public class _1551MinimumOperationstoMakeArrayEqual {
	public int minOperations(int n) {
		int avg = n;
		int res = 0;
		for (int i = 0; i <= (n - 1) / 2; i++) {
			res += Math.abs((2 * i + 1 - avg));
		}
		return res;
	}
}

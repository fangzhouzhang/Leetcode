public class _188BestTimetoBuyandSellStockIV {
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		if (k > prices.length / 2) {
			int res = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) {
					res += prices[i] - prices[i - 1];
				}
			}
			return res;
		}

		long[] b = new long[k + 1];
		long[] s = new long[k + 1];
		for (int i = 1; i <= k; i++) {
			b[i] = Integer.MIN_VALUE;
		}

		for (int p : prices) {
			for (int i = k; i >= 1; i--) {
				s[i] = Math.max(s[i], b[i] + p);
				if (i == 1) b[i] = Math.max(b[i], -p);
				else b[i] = Math.max(b[i], s[i - 1] - p);
			}
		}
		long res = Integer.MIN_VALUE;
		for (long n : s) res = Math.max(res, n);
		for (long n : b) res = Math.max(res, n);
		return (int)res;
	}
}

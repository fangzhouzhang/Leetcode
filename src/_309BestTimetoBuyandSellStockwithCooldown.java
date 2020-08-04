public class _309BestTimetoBuyandSellStockwithCooldown {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		long[] hold = new long[prices.length];
		long[] unhold = new long[prices.length];
		hold[0] = -prices[0];
		// unhold[0] = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {
			unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
			if (i != 1) {
				hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
			} else {
				hold[i] = Math.max(hold[i - 1], -prices[1]);
			}

		}
		return (int)unhold[prices.length - 1];
	}
}

public class _714BestTimetoBuyandSellStockwithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		if (prices == null || prices.length == 0) return 0;
		int n = prices.length, hold = -prices[0], unhold = 0;
		for (int i = 1; i < n; i++) {
			unhold = Math.max(hold + prices[i]- fee, unhold);
			hold = Math.max(hold, unhold - prices[i]);
		}
		return Math.max(unhold, hold);
	}
}

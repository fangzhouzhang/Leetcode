public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				max += prices[i + 1] - prices[i];
			}
		}
		return max;
	}
}

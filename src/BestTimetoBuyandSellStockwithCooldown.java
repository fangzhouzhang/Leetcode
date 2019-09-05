public class BestTimetoBuyandSellStockwithCooldown {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int[] hold = new int[prices.length];
		int[] unhold = new int[prices.length];
		hold[0] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (i == 1) {
				hold[i] = Math.max(-prices[1], hold[0]);
			} else {
				hold[i] = Math.max(unhold[i - 2] - prices[i], hold[i - 1]);
			}

			unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
		}
		return unhold[prices.length - 1];
	}
}

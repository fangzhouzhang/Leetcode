public class BestTimetoBuyandSellStock {
	/**
	 * time: o(n^2) space: o(n)
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices.length == 1) {
			return 0;
		}
		int[] dp = new int[prices.length];
		int max = 0;
		for (int i = prices.length - 1; i >= 1; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (prices[i] - prices[j] > 0) {
					max = Math.max(max, prices[i] - prices[j]);
				}
			}
		}
		return max;
	}
}

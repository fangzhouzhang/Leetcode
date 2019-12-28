public class _123BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int[] tmp = new int[prices.length];
		int[] pre = new int[prices.length];
		int[] cur = new int[prices.length];
		for (int i = 1; i <= 2; i++) {
			int localMax = pre[0] - prices[0];
			for (int j = 1; j < prices.length; j++) {
				cur[j] = Math.max(cur[j - 1], prices[j] + localMax);
				localMax = Math.max(localMax, pre[j] - prices[j]);
			}
			tmp = pre;
			pre = cur;
			cur = tmp;
		}
		return pre[prices.length - 1];
	}
}

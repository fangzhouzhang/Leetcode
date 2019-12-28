public class _188BestTimetoBuyandSellStockIV {
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		if (k > prices.length / 2) {
			int sum = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) sum += prices[i] - prices[i - 1];
			}
			return sum;
		}
		int[] tmp = new int[prices.length];
		int[] pre = new int[prices.length];
		int[] cur = new int[prices.length];
		for (int i = 1; i <= k; i++) {
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

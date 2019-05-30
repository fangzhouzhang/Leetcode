public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		int buy1 = Integer.MAX_VALUE, buy2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;

		for (int price: prices) {
			buy1 = Math.min(buy1, price);
			sell1 = Math.max(sell1, price - buy1);
			buy2 = Math.max(buy2, sell1 - price);
			sell2 = Math.max(sell2, price + buy2);
		}
		return sell2;
	}
}

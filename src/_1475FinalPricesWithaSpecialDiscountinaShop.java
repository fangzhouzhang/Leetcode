import java.util.Stack;

public class _1475FinalPricesWithaSpecialDiscountinaShop {
	public int[] finalPrices(int[] prices) {
		if (prices == null || prices.length == 0) return new int[0];
		int n = prices.length;
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		while (idx < n) {
			if (stack.size() == 0 || prices[stack.peek()] < prices[idx]) stack.push(idx++);
			else {
				int cur = stack.pop();
				res[cur] = prices[cur] - prices[idx];
			}
		}
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			res[cur] = prices[cur];
		}
		return res;
	}
}

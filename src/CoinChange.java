import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] res = new int[1];
		res[0] = Integer.MAX_VALUE;
		Arrays.sort(coins);
		int idx = coins.length - 1;
		dfs(coins, amount, idx, res, 0);
		return res[0] == Integer.MAX_VALUE ? -1 : res[0];
	}
	private void dfs(int[] coins, int amount, int idx, int[] res, int cur) {
		if (idx < 0) {
			return;
		}
		if (amount % coins[idx] == 0) {
			res[0] = Math.min(res[0], cur + amount / coins[idx]);
			return;
		}
		//amount % coins[idx] != 0, cur >= cur + amount / coins[idx] + 1
		for (int i = amount / coins[idx]; i >= 0; i--) {
			if (cur + i + 1 >= res[0]) {
				break;
			}
			dfs(coins, amount - i * coins[idx], idx - 1, res, cur + i);
		}
	}
}

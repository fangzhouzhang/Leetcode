import java.util.Arrays;

public class _1833MaximumIceCreamBars {
	public int maxIceCream(int[] costs, int coins) {
		int n = costs.length;
		int res = 0;
		Arrays.sort(costs);
		for (int i = 0; i < n; i++) {
			if (coins >= costs[i]) {
				res++;
				coins -= costs[i];
			}
		}
		return res;
	}
}

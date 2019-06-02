public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0) {
			return 0;
		}
		if (cost.length == 1) {
			return cost[0];
		}
		int[] mem = new int[cost.length];

		dfs(cost, 0, mem);
		return Math.min(mem[0], mem[1]);
	}

	private int dfs(int[] cost, int idx, int[] mem) {
		if (idx >= cost.length) {
			return 0;
		}

		if (mem[idx] != 0) {
			return mem[idx];
		}

		int min = Integer.MAX_VALUE;


		min = Math.min(min, dfs(cost, idx + 1, mem) + cost[idx]);

		min = Math.min(min, dfs(cost, idx + 2, mem) + cost[idx]);


		mem[idx] = min;
		return min;
	}
}

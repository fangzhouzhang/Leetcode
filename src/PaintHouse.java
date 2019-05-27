public class PaintHouse {
	public int minCost(int[][] costs) {
		if (costs.length == 0) {
			return 0;
		}
		int[][] mem = new int[costs.length][costs[0].length];
		dfs(costs, 0, 0, mem);
		return mem[0][0];
	}
	private int dfs(int[][] costs, int idx, int prev, int[][] mem) {
		if (idx == costs.length) {
			return 0;
		}
		if (mem[idx][prev] != 0) {
			return mem[idx][prev];
		}


		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (idx != 0 && i == prev) {
				continue;
			}
			min = Math.min(min, dfs(costs, idx + 1, i, mem) + costs[idx][i]);
		}
		mem[idx][prev] = min;
		return mem[idx][prev];
	}
}

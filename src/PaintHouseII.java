public class PaintHouseII {
	public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0) {
			return 0;
		}
		int[][] mem = new int[costs.length][costs[0].length];

		return dfs(costs, -1, 0, mem);
	}
	private int dfs(int[][] costs, int prevChoice, int level, int[][] mem) {
		if (level == costs.length) {
			return 0;
		}

		if (level > 0 && mem[level - 1][prevChoice] != 0) {
			return mem[level - 1][prevChoice];
		}

		if (level == 0) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < costs[0].length; i++) {
				min = Math.min(min, dfs(costs, i, level + 1, mem) + costs[level][i]);
			}
			return min;

		} else {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < costs[0].length; i++) {
				if (i == prevChoice) {
					continue;
				}
				min = Math.min(min, dfs(costs, i, level + 1, mem) + costs[level][i]);
			}
			mem[level - 1][prevChoice] = min;
			return min;
		}
	}
}

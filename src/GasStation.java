public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		/**

		 maintain global startIndex -1

		 for each point
		 update tank oil, cost, nextPos,
		 **/
		int total = 0;
		int start = 0;
		int curProfit = 0;// gas[i] - cost[i]
		for (int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];
			curProfit += gas[i] - cost[i];
			if (curProfit < 0) {
				curProfit = 0;
				start = i + 1;
			}
		}
		return total < 0 ? -1 : start;
	}
}

public class StoneGame {
	public boolean stoneGame(int[] piles) {
		int[][] dp = new int[piles.length][piles.length];


		for (int offset = 0; offset < piles.length; offset++) {
			for (int start = 0;  start + offset < piles.length; start++) {
				if (offset == 0) {
					dp[start][start + offset] = piles[start];
				} else if (offset == 1) {
					dp[start][start + offset] =
							Math.max(piles[start], piles[start + offset]);
				} else {
					dp[start][start + offset] = calVal(dp, start, offset, piles);
				}
			}
		}


		int sum = getSum(piles);

		return dp[0][piles.length - 1] > (sum / 2) ? true : false;
	}
	private int calVal(int[][] dp,
					   int start,
					   int offset,
					   int[] piles) {
		int temp = 0;
		//choose piles[start]
		if (piles[start + 1] > piles[start + offset]) {
			temp = Math.max(temp, dp[start + 2][start + offset] + piles[start]);
		} else {
			temp = Math.max(temp, dp[start + 1][start + offset - 1] + piles[start]);
		}
		//choose piles[start + offset]
		if (piles[start] > piles[start + offset - 1]) {
			temp = Math.max(temp, dp[start + 1][start + offset - 1] + piles[start + offset]);
		} else {
			temp = Math.max(temp, dp[start][start + offset - 2] + piles[start + offset]);
		}

		return temp;
	}

	private int getSum(int[] piles) {
		int sum = 0;
		for (int i = 0; i < piles.length; i++) {
			sum += piles[i];
		}
		return sum;
	}
}

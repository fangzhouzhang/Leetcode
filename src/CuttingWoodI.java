import org.junit.Test;

public class CuttingWoodI {
	/**
	 *
	 * @param cuts length of cut point at a wood
	 * @param length total length of wood
	 * @return
	 * time: o(n^3) space: o(n^2)
	 */
	public int minCost(int[] cuts, int length) {
		// Write your solution here
		int[] len = new int[cuts.length + 2];
		len[0] = 0;
		len[len.length - 1] = length;
		for (int i = 0; i < cuts.length; i++) {
			len[i + 1] = cuts[i];
		}
		int min = Integer.MAX_VALUE;
		int[][] dp = new int[len.length][len.length];
		for (int start = 0; start + 1 < len.length; start++) {
			dp[start][start + 1] = 0;
		}
		for (int size = 2; size < len.length; size++) {
			for (int start = 0; start + size < len.length; start++) {
				min = Integer.MAX_VALUE;
				for (int temp = 1; temp < size; temp++) {
					min = Math.min(min, len[start + size] - len[start] + dp[start][start + temp] + dp[start + temp][start + size]);
				}
				dp[start][start + size] = min;
			}
		}
		for (int i = 0; i < len.length; i++) {
			for (int j = i + 1; j < len.length; j++) {
				System.out.println("dp" + i + j + ":  " + dp[i][j]);
			}
		}
		return dp[0][len.length - 1];
	}
	/*@Test
	public void testCuttingWood() {
		int[] cuts = {2,4,7};
		int length = 10;
		minCost(cuts, length);
	}*/
}



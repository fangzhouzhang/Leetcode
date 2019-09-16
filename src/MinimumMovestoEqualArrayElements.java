public class MinimumMovestoEqualArrayElements {
	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int n : nums) {
			min = Math.min(n, min);
		}
		int res = 0;
		for (int n : nums) {
			res += (n - min);
		}
		return res;
	}
}

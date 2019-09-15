import java.util.HashMap;

public class ArithmeticSlicesIISubsequence {
	public int numberOfArithmeticSlices(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer>[] dp = new HashMap[A.length];
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			dp[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {
				long delta = (long)A[i] - (long)A[j];
				if (delta >= Integer.MAX_VALUE || delta <= Integer.MIN_VALUE) {
					continue;
				}
				int diff = (int)delta;
				if (dp[i].containsKey(diff)) {
					dp[i].put(diff, dp[i].get(diff) + 1);
				} else {
					dp[i].put(diff, 1);
				}
				/**
				 dp[j].get(diff)存储坐标j 差值为diff的元素个数m，如果m大于或者等于1，意味当前A[i]可以与之前的这些数字，构成m个新的等差数列
				 更新i坐标与之前元素差值为diff的数字

				 dp[j].get(diff) stores element number /m/ which has consecutive difference from index 0 to index j.
				 If m is >= 1, it means A[i] can form m new arithmetic subsequences. Then update  element number which has consecutive difference from index 0 to index i
				 **/
				if (dp[j].containsKey(diff) && dp[j].get(diff) >= 1) {
					res += dp[j].get(diff);
					dp[i].put(diff, dp[i].get(diff) + dp[j].get(diff));
				}
			}
		}
		return res;
	}
}

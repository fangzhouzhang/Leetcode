import java.util.Arrays;

public class IntegerBreak {
	public int integerBreak(int n) {
		int[] res = new int[n + 1];
		Arrays.fill(res, 1);
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				res[i] = Math.max(res[i], Math.max(j * (i - j), j * res[i - j]));
			}
		}
		return res[n];
	}
}

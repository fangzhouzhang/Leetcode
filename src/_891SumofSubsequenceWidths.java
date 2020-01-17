import java.util.Arrays;

public class _891SumofSubsequenceWidths {
	public int sumSubseqWidths(int[] A) {
		int M = 1000000007;
		long res = 0;
		int n = A.length;
		long[] pow2 = new long[n];
		pow2[0] = 1;
		for (int i = 1; i < n; i++) pow2[i] = pow2[i - 1] * 2 % M;
		Arrays.sort(A);
		for (int i = 0; i < n; i++) {
			res -= A[i] * pow2[n - 1 - i] % M;
			res += A[i] * pow2[i] % M;
			res = res % M;
		}
		return (int)res;
	}
}

public class _1031MaximumSumofTwoNonOverlappingSubarrays {
	public int maxSumTwoNoOverlap(int[] A, int L, int M) {
		if (A == null || A.length == 0 || A.length < L + M) return 0;
		int n = A.length;
		int[] prefix = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += A[i];
			prefix[i + 1] = sum;
		}
		int res = 0;
		int lmax = prefix[L];
		int mmax = prefix[M];
		for (int i = L + M - 1; i < n; i++) {
			lmax = Math.max(lmax, prefix[i - M + 1] - prefix[i - L - M + 1]);
			mmax = Math.max(mmax, prefix[i - L + 1] - prefix[i - L - M + 1]);
			res = Math.max(res, prefix[i + 1] - prefix[i + 1 - M] + lmax);
			res = Math.max(res, prefix[i + 1] - prefix[i + 1 - L] + mmax);
		}
		return res;
	}
}

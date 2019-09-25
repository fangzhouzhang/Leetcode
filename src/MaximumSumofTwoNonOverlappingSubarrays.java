public class MaximumSumofTwoNonOverlappingSubarrays {
	public int maxSumTwoNoOverlap(int[] A, int L, int M) {
		if (A.length < L + M) return 0;
		int[] prefix = new int[A.length + 1];
		int sum = 0;
		for (int i = 1; i < prefix.length; i++) {
			sum += A[i - 1];
			prefix[i] = sum;
		}
		int res = prefix[L + M];
		int lmax = prefix[L];
		int mmax = prefix[M];
		for (int i = L + M; i < A.length; i++) {
			lmax = Math.max(lmax, prefix[i - M + 1] - prefix[i - L - M + 1]);
			mmax = Math.max(mmax, prefix[i - L + 1] - prefix[i - L - M + 1]);
			res = Math.max(res, prefix[i + 1] - prefix[i - M + 1] + lmax);
			res = Math.max(res, prefix[i + 1] - prefix[i - L + 1] + mmax);
		}
		return res;
	}
}

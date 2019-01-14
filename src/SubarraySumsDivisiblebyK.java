public class SubarraySumsDivisiblebyK {
	public int subarraysDivByK(int[] A, int K) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] res = new int[A.length + 1];
		int temp = 0;
		for (int i = 1; i < res.length; i++) {
			temp += A[i - 1];
			res[i] = temp;
		}
		int ans = 0;
		for (int i = 0; i < res.length - 1; i++) {
			for (int j = i + 1; j < res.length; j++) {
				if ((res[j] - res[i]) % K == 0) {
					ans++;
				}
			}
		}
		return ans;
	}
}

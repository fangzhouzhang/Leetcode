public class PrimeArrangements {
	public int numPrimeArrangements(int n) {
		int MOD = (int) (1e9 + 7);
		boolean[] notPrime = new boolean[n + 1];
		notPrime[1] = true;
		for (int i = 2; i < notPrime.length; i++) {
			if (!notPrime[i]) {
				for (int j = i * i; j < notPrime.length; j += i) {
					notPrime[j] = true;
				}
			}
		}
		long res = 1;
		int cnt = 0;
		for (boolean b : notPrime) {
			if (b) {
				cnt++;
			}
		}
		System.out.println(cnt);
		for (int i = 2; i <= cnt; i++) {
			res = res * i % MOD;
		}
		for (int i = 2; i <= n - cnt; i++) {
			res = res * i % MOD;
		}
		return (int)res;
	}
}

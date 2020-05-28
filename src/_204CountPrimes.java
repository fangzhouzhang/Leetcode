public class _204CountPrimes {
	public int countPrimes(int n) {
		if (n <= 1) return 0;
		boolean[] notP = new boolean[n];
		for (int i = 2; i * i <= n; i++) {
			if (!notP[i]) {
				for (int j = 2; j * i < n; j++) notP[j * i] = true;
			}
		}

		int res = 0;
		for (int i = 2; i < n; i++) {
			if (!notP[i]) res++;
		}
		return res;
	}
}

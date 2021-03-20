public class _1652DefusetheBomb {
	public int[] decrypt(int[] code, int k) {
		if (code == null || code.length == 0) return new int[0];
		int n = code.length;
		int[] res = new int[n];
		if (k == 0) return res;
		if (k > 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 1; j <= Math.abs(k); j++) {
					res[i] += code[(i + j) % n];
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 1; j <= Math.abs(k); j++) {
					if (i - j < 0)
						res[i] += code[n - Math.abs(i - j)];
					else
						res[i] += code[(i - j) % n];
				}
			}
		}
		return res;
	}
}

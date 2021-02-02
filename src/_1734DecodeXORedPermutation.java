public class _1734DecodeXORedPermutation {
	public int[] decode(int[] encoded) {
		int r = 0, n = encoded.length;
		for (int i = 1; i < n; i += 2) {
			r ^= encoded[i];
		}
		int c = 0;
		for (int i = 1; i <= n + 1; i++)
			c ^= i;
		int a1 = c ^ r;
		int[] res = new int[n + 1];
		res[0] = a1;
		for (int i = 1; i < n + 1; i++) {
			int cur = encoded[i - 1] ^ a1;
			res[i] = cur;
			a1 = cur;
		}
		return res;
	}
}

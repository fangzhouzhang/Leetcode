public class _1318MinimumFlipstoMakeaORbEqualtoc {
	public int minFlips(int a, int b, int c) {
		int res = 0;
		while (a != 0 || b!= 0 || c!= 0) {
			int cn = c & 1;
			int bn = b & 1;
			int an = a & 1;
			if (cn == 1) {
				if (an == 0 && bn == 0) res += 1;
			} else if (cn == 0) {
				if (an == 1 && bn == 1) res += 2;
				else if (an == 1 || bn == 1) res += 1;
			}
			c >>= 1;
			b >>= 1;
			a >>= 1;
		}
		return res;
	}
}

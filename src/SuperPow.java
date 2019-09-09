public class SuperPow {
	private static int M = 1337;
	public int superPow(int a, int[] b) {
		int res = 1;
		for (int i = b.length - 1; i >= 0; i--) {
			res = (res * normalPow(a, b[i])) % M;
			a = normalPow(a, 10);
		}
		return res;
	}

	private int normalPow(int a, int b) {
		a %= M;
		int res = 1;
		while (b != 0) {
			if (b % 2 != 0) {
				res = (res * a) % M;
			}
			a = a * a % M;
			b /= 2;
		}
		return res;
	}
}

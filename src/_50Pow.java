public class _50Pow {
	/*
	 * @param x: the base number
	 * @param n: the power number
	 * @return: the result
	 * time : o(logn) space:o(logn)
	 */
	public double myPow(double x, int n) {
		// return Double.MAX_VALUE;
		if (x == 0.0) {
			return 0.0;
		}
		if (x == 1.0) {
			return 1.0;
		}
		if (n == 0) {
			return 1.0;
		}
		if (n == 1) {
			return x;
		}
		if (n > 0) {
			double t = myPow(x, n / 2);
			return n % 2 == 0 ? t * t : x * t * t;
		} else {
			double t = myPow(x, -1 * (n / 2));
			return n % 2 == 0 ? 1 / (t * t) :
					1 / (t * t * x);
		}
	}
	/*
	 * @param x: the base number
	 * @param n: the power number
	 * @return: the result
	 * time : o(logn) space:o(1)
	 */
	public double myPowIterative(double x, int n) {
		double base = x;
		double res = 1;
		long N = Math.abs((long)n);
		while (N > 0) {
			if ((N & 1) == 1) {
				res *= base ;
			}
			N >>= 1;
			base *= base;
		}
		return n > 0 ? res : 1 / res;
	}
}

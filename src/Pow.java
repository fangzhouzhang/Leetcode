public class Pow {
	/*
	 * @param x: the base number
	 * @param n: the power number
	 * @return: the result
	 * time : o(n) space:o(logn)
	 */
	public double myPow(double x, int n) {
		// write your code here
		if (x == 0) {
			return 0.0;
		} else if (n == 0) {
			return 1.0;
		} else if (n == Integer.MIN_VALUE) {
			return 0.0;
		} else if (n < 0) {
			return 1 / myPow(x, -n);
		}
		if (n % 2 == 0) {
			return myPow(x,  n/2) * myPow(x,  n/2);
		} else {
			return myPow(x,  n/2) * myPow(x,  n/2) * x;
		}
	}
}

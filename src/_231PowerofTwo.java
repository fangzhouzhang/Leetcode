public class _231PowerofTwo {
    /**
     * @param n: an integer
     * @return: if n is a power of two
     */
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
		return (n & (n - 1)) == 0;
	}

	public boolean isPowerOfTwo1(int n) {
		if (n == 1) return true;
		if (n <= 0 || (n % 2 == 1)) return false;
		while (n > 1) {
			if (n % 2 == 1) return false;
			n >>= 1;
		}
		return true;
	}
}

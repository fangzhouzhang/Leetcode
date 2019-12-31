public class _231PowerofTwo {
    /**
     * @param n: an integer
     * @return: if n is a power of two
     */
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
		return (n & (n - 1)) == 0;
	}
}

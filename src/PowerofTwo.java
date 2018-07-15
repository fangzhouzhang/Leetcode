public class PowerofTwo {
    /**
     * @param n: an integer
     * @return: if n is a power of two
     */
    public boolean isPowerOfTwo(int n) {
        // Write your code here
        return (n & n - 1) == 0;
    }
}

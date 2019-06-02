public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		int bitsRight = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			bitsRight++;
		}
		return (m <<= bitsRight);
	}
}

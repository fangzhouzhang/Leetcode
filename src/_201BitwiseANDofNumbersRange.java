public class _201BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		int res = 0;
		for (int i = 31; i >= 0; i--) {
			if ((m & (1 << i)) != (n & (1 << i))) break;
			else res |= (m & (1 << i));
		}
		return res;
	}
}

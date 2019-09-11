public class IntegerReplacement {
	public int integerReplacement(int n) {
		long l = (long)n;
		int min = 0;
		while (l > 1) {
			min++;
			if (l % 2 == 0) {
				l >>= 1;
			} else {
				if ((l & 0b11) == 3 && l != 3) {
					l += 1;
				} else if ((l & 0b01) == 1) {
					l -= 1;
				}
			}
		}
		return min;
	}
}

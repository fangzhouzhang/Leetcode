public class ReverseBits {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int l = 31;
		int r = 0;
		while (l > r) {
			if (((n >> l) & 1) != ((n >> r) & 1)) {
				n = n ^ (1 << l);
				n = n ^ (1 << r);
			}
			l--;
			r++;
		}
		return n;
	}
}

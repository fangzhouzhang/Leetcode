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
	public int reverseBits1(int n) {
		int ret = n;
		ret = (ret & 0xffff0000) >>> 16 | (ret & 0x0000ffff) << 16;
		ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8;
		ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4;
		ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;
		ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;
		return ret;
	}
}

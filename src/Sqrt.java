public class Sqrt {
	public int mySqrt(int x) {
		if (x == 0) {
			return 0;
		}
		long l = 0;
		long r = x;
		while (l + 1 < r) {
			long mid = l + (r - l) / 2;
			if (mid * mid == x) {
				return (int)mid;
			} else if (mid * mid < x) {
				l = mid;
			} else {
				r = mid;
			}
		}
		if (r * r <= x) {
			return (int)r;
		}
		if (l * l <= x) {
			return (int)l;
		}
		return -1;
	}
}

public class _69SqrtX {
	public int mySqrt(int x) {
		if (x == 0) return 0;
		int l = 1, r = (int)Math.sqrt(x);
		while (l < r) {
			int mid = l + r + 1 >> 1;
			if (mid * mid <= x) l = mid;
			else r = mid - 1;
		}
		return l;
	}
}

public class _7ReverseInteger {
	public int reverse(int x) {
		long reverse = 0;
		boolean isNeg = x < 0;
		x = Math.abs(x);
		while (x > 0) {
			int digit = x % 10;
			reverse = reverse * 10 + digit;
			x /= 10;
		}
		if (isNeg) {
			reverse *= -1;
			if (reverse < Integer.MIN_VALUE) return 0;
		} else {
			if (reverse > Integer.MAX_VALUE) return 0;
		}
		return (int)reverse;
	}
}

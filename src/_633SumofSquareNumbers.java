public class _633SumofSquareNumbers {
	public boolean judgeSquareSum(int c) {
		if (c < 0) return false;
		int l = 0, r = (int)Math.sqrt(c);
		while (l <= r) {
			int cur = l * l + r * r;
			if (cur == c) return true;
			else if (cur < c) l++;
			else r--;
		}
		return false;
	}
}

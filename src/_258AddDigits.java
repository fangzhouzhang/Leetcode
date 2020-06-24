public class _258AddDigits {
	public int addDigits(int num) {
		int cur = num;
		while (true) {
			int val = 0;
			while (cur != 0) {
				int digit = cur % 10;
				val = val + digit;
				cur /= 10;
			}
			if (val < 10) return val;
			else cur = val;
		}
	}
}

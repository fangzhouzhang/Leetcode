public class NthDigit {
	public int findNthDigit(int n) {
		int start = 1;
		long base = 9;
		int len = 1;
		while (n > len * base) {
			n = n - len * (int)base;
			len++;
			start *= 10;
			base *= 10;
		}
		int target = start + (n - 1) / len;
		int pos = (n - 1) % len;
		return Character.getNumericValue(Integer.toString(target).charAt(pos));
	}
}

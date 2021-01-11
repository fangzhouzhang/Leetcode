public class _1716CalculateMoneyinLeetcodeBank {
	public int totalMoney(int n) {
		int fullSize = n / 7;
		if (fullSize == 0) return (1 + n) * n / 2;
		int res = 0;
		res = (28 + 28 + 7 * (fullSize - 1)) * (fullSize) / 2;
		int last = n % 7;
		res = res + (1 + last) * (last) / 2 + 1 * last * fullSize;
		return res;
	}
}

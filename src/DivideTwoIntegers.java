public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		if (divisor == 0) {
			return -1;
		}
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			sign = -1;
		}
		long ldividend = dividend;
		long ldivisor = divisor;
		ldividend = (long)Math.abs(ldividend);
		ldivisor = (long)Math.abs(ldivisor);;
		long res = add(ldividend, ldivisor);
		if (res > Integer.MAX_VALUE) {
			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			return (int) res * sign;
		}
	}
	public long add(long dividend, long divisor) {
		if (dividend < divisor) {
			return 0;
		}
		long sum = divisor;
		long multiple = 1;
		while (sum + sum< dividend) {
			sum += sum;
			multiple += multiple;
		}
		return multiple + add(dividend - sum, divisor);
	}
}

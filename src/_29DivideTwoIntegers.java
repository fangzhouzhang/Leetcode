public class _29DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		long a = (long)dividend, b = (long)divisor;
		boolean isNeg = false;
		if ((a < 0 && b > 0) || (a > 0 && b < 0)) isNeg = true;
		a = Math.abs(a);
		b = Math.abs(b);
		long[] arr = new long[32];
		long sum = b;
		for (int i = 0; i < 32; i++) {
			arr[i] = sum;
			sum += sum;
		}
		long res = 0;
		int idx = 31;
		while (a > 0 && idx >= 0) {
			if (a >= arr[idx]) {
				res += (long)(1l << idx);
				System.out.println(res);
				a -= arr[idx];
			}
			idx--;
		}
		res = isNeg ? -1 * res : res;
		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int)res;
	}
}

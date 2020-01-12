public class _1317ConvertIntegertotheSumofTwoNoZeroIntegers {
	public int[] getNoZeroIntegers(int n) {
		int[] res = new int[2];
		for (int i = 1; i < n; i++) {
			if (isNoZero(i) && isNoZero(n - i)) {
				res[0] = i;
				res[1] = n - i;
				return res;
			}
		}
		return new int[2];
	}

	private boolean isNoZero(int num) {
		String str = num + "";
		for (char c : str.toCharArray()) {
			if (c == '0') return false;
		}
		return true;
	}
}

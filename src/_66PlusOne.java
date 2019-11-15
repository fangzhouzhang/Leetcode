public class _66PlusOne {
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		int carry = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (i == n - 1) {
				if (digits[i] + 1 == 10) {
					carry = 1;
					digits[i] = 0;
				} else {
					digits[i] += 1;
				}
			} else {
				if (digits[i] + carry == 10) {
					carry = 1;
					digits[i] = 0;
				} else {
					digits[i] += carry;
					carry = 0;
				}
			}
		}

		if (carry == 1) {
			int[] res = new int[n + 1];
			res[0] = 1;
			for (int i = 0; i < n; i++) {
				res[i + 1] = digits[i];
			}
			return res;
		} else return digits;
	}
}

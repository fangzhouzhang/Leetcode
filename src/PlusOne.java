public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == digits.length - 1) {
				digits[i] += 1;
				if (digits[i] != 10) {
					return digits;
				} else {//digits[i] == 10
					digits[i] = 0;
					carry = 1;
				}
			} else  {
				digits[i] += carry;
				if (digits[i] != 10) {
					carry = 0;
				} else {
					digits[i] = 0;
					carry = 1;
				}
			}
		}
		if (carry == 1) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			for (int i = 1; i < res.length; i++) {
				res[i] = digits[i - 1];
			}
			return res;
		} else {
			return digits;
		}
	}
}

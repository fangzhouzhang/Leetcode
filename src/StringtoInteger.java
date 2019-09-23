public class StringtoInteger {
	public int myAtoi(String str) {
		//escape space
		int i = 0;
		while (i < str.length() && str.charAt(i) == ' ') i++;

		//get sign
		int sign = 1;
		if (i < str.length() && str.charAt(i) == '+') {
			i++;
		} else if (i < str.length() && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}

		long res = 0;
		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			res = res * 10 + (str.charAt(i) - '0');
			if (res * sign>= Integer.MAX_VALUE) {
				return 2147483647;
			} else if (res * sign <= Integer.MIN_VALUE) {
				return -2147483648;
			}
			i++;
		}
		return (int)(res * sign);
	}
}

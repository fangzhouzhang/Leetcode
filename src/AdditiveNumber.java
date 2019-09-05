public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		if (num.length() == 0) {
			return false;
		}
		for (int i = 1; i <= num.length() / 2; i++) {
			if (num.charAt(0) == '0' && i > 1) {
				return false;
			}
			for (int j = i + 1; j < num.length(); j++) {
				if (num.charAt(i) == '0' && j - i > 1) {
					break;
				}
				if (dfs(num, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(String num, int firstStart, int firstEnd, int secondEnd) {
		Long first = Long.valueOf(num.substring(firstStart, firstEnd));
		Long second = Long.valueOf(num.substring(firstEnd, secondEnd));

		Long sum = first + second;
		String add = sum + "";

		if (!num.substring(secondEnd).startsWith(add)) {
			return false;
		}
		if (secondEnd + add.length() == num.length()) {
			return true;
		}
		return dfs(num, firstEnd, secondEnd, secondEnd + add.length());
	}
}

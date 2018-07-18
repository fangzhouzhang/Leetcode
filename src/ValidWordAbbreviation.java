public class ValidWordAbbreviation {
	/**
	 * @param word: a non-empty string
	 * @param abbr: an abbreviation
	 * @return: true if string matches with the given abbr or false
	 * recursive version
	 * time: o(n) space:o(n) 93% cases pass
	 */
	public boolean validWordAbbreviation(String word, String abbr) {
		// write your code here
		if (abbr == null || abbr.length() == 0) {
			return false;
		}
		if (abbr.length() > word.length()) {
			return false;
		}
		char[] str1 = word.toCharArray();
		char[] str2 = abbr.toCharArray();
		return dfs(str1, 0, str2, 0);
	}
	public boolean dfs(char[] str1, int start1, char[] str2, int start2) {
		if (start1 >= str1.length && start2 >= str2.length) {//base case
			return true;
		} else if (start1 >= str1.length || start2 >= str2.length) {
			return false;
		}
		if (isDigit(str2, start2)) {//position here is digit
			int num = 0;
			while (start2 < str2.length && isDigit(str2, start2)) {
				num = num * 10 + str2[start2++] - '0';
			}
			if (num + start1 > str1.length) {
				return false;
			} else {
				return dfs(str1, start1 + num, str2, start2);
			}
		} else {//position here is a char
			if (str1[start1] != str2[start2]) {
				return false;
			} else {
				return dfs(str1, start1 + 1, str2, start2 + 1);
			}
		}
	}
	public boolean isDigit(char[] arr, int i) {
		return arr[i] >= '0' && arr[i] <= '9';
	}
	/**
	 * @param word: a non-empty string
	 * @param abbr: an abbreviation
	 * @return: true if string matches with the given abbr or false
	 * iterative version
	 * time : o(n) space: o(1)
	 */
	public boolean validWordAbbreviation1(String word, String abbr) {
		// write your code here
		if (abbr == null || abbr.length() == 0) {
			return false;
		}
		if (abbr.length() > word.length()) {
			return false;
		}
		char[] str1 = word.toCharArray();
		char[] str2 = abbr.toCharArray();
		int start1 = 0;
		int start2 = 0;
		while (start1 < str1.length && start2 < str2.length) {
			if (isDigit(str2, start2)) {//position here is digit
				int num = 0;
				while (start2 < str2.length && isDigit(str2, start2)) {
					num = num * 10 + str2[start2++] - '0';
				}
				if (num + start1 > str1.length) {
					return false;
				} else {
					start1 += num;
				}
			} else {//position here is a char
				if (str1[start1] != str2[start2]) {
					return false;
				} else {
					start1++;
					start2++;
				}
			}
		}

		if (start1 >= str1.length && start2 >= str2.length) {//base case
			return true;
		} else  {
			return false;
		}
	}
}

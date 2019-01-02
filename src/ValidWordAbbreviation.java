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
	public boolean validWordAbbreviationI(String word, String abbr) {
		// write your code here
		if (abbr == null || abbr.length() == 0) {
			return false;
		}
		if (abbr.length() > word.length()) {
			return false;
		}
		int start1 = 0;
		int start2 = 0;
		while (start1 < word.length() && start2 < abbr.length()) {
			char c1 = word.charAt(start1);
			char c2 = abbr.charAt(start2);
			if (isDigit(abbr, start2)) {//position here is digit
				int num = 0;
				while (start2 < abbr.length() && isDigit(abbr, start2)) {
					c2 = abbr.charAt(start2);
					num = num * 10 + c2 - '0';
					start2++;
				}
				if (num + start1 > word.length()) {
					return false;
				} else {
					start1 += num;
				}
			} else {//position here is a char
				if (c1 != c2) {
					return false;
				} else {
					start1++;
					start2++;
				}
			}
		}

		if (start1 >= word.length() && start2 >= abbr.length()) {//base case
			return true;
		} else  {
			return false;
		}
	}

	public boolean isDigit(String abbr, int i) {
		return abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9';
	}

	public boolean validWordAbbreviationII(String word, String abbr) {
		if (word == null ||
				word.length() == 0 ||
				word.length() < abbr.length()) {
			return false;
		}
		int[] idx = new int[2];
		idx[0] = 0;//index for word
		idx[1] = 0;//index for abbr
		while (idx[1] < abbr.length()) {
			char c = abbr.charAt(idx[1]);
			if (isNum(c)) {
				int start = idx[1];
				int end = getNum(abbr, idx);
				int offset = Integer.parseInt(abbr.substring(start, end));
				if (!isValidDigit(start, end, offset)) {
					return false;
				}
				idx[0] += offset;
				System.out.println(offset + " " + idx[0]);
			} else {//c is letter
				if (idx[0] >= word.length() ||
						c != word.charAt(idx[0])) {
					return false;
				} else {
					idx[0]++;//index for word
					idx[1]++;
				}
			}
		}
		if (idx[0] != word.length()) {
			return false;
		}
		return true;
	}

	private boolean isNum(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}

	private int getNum(String abbr, int[] idx) {
		while (idx[1] < abbr.length() &&
				isNum(abbr.charAt(idx[1]))) {
			idx[1]++;
		}
		return idx[1];
	}
	private boolean isValidDigit(int start, int end, int offset) {
		int num = 0;
		while (offset > 0) {
			offset /= 10;
			num++;
		}
		return end - start == num;
	}
}

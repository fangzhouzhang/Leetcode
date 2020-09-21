public class _1592RearrangeSpacesBetweenWords {
	public String reorderSpaces(String text) {
		int space = 0;
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			if (c == ' ') space++;
		}
		int idx = 0;
		while (idx < text.length()) {
			if (text.charAt(idx) == ' ') {
				idx++;
			} else {
				while (idx < text.length() && text.charAt(idx) != ' ') {
					sb.append(text.charAt(idx++));
				}
				sb.append(' ');
			}
		}
		String[] arr = sb.toString().split(" ");
		int number = arr.length;
		if (number == 1) {
			sb = new StringBuilder();
			sb.append(arr[0]);
			for (int k = 0; k < space; k++) {
				sb.append(' ');
			}
			return sb.toString();
		}
		if (space % (number - 1) == 0) {
			sb = new StringBuilder();
			for (int i = 0; i < number; i++) {
				String a = arr[i];
				sb.append(a);
				//add spaces
				if (i == number - 1) continue;
				for (int k = 0; k < space / (number - 1); k++) {
					sb.append(' ');
				}
			}
			return sb.toString();
		} else {
			int spaceBetweenWords = space / (number - 1);
			int lastSpace = space % (number - 1);
			sb = new StringBuilder();
			for (int i = 0; i < number; i++) {
				String a = arr[i];
				sb.append(a);
				//add spaces
				if (i == number - 1)  {
					for (int k = 0; k < lastSpace; k++) {
						sb.append(' ');
					}
				} else {
					for (int k = 0; k < space / (number - 1); k++) {
						sb.append(' ');
					}

				}
			}
			return sb.toString();
		}
	}
}

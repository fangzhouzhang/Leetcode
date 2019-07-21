public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s.length() == 0) {
			return "";
		}
		char[] arr = s.toCharArray();
		StringBuilder[] sbs = new StringBuilder[numRows];
		for (int i = 0; i < sbs.length; i++) {
			sbs[i] = new StringBuilder();
		}
		int charIdx = 0;
		while (charIdx < arr.length) {
			for (int i = 0; i < numRows && charIdx < arr.length; i++, charIdx++) {
				sbs[i].append(arr[charIdx]);
			}
			for (int i = numRows - 2; i >= 1 && charIdx < arr.length; i--, charIdx++) {
				sbs[i].append(arr[charIdx]);
			}
		}
		for (int i = 1; i < sbs.length; i++) {
			sbs[0].append(sbs[i]);
		}
		return new String(sbs[0]);
	}
}

public class _604DesignCompressedStringIterator {
	private class StringIterator {
		private int idx = 0;
		private String s = null;
		private char c = ' ';
		private int num = -1;
		public StringIterator(String compressedString) {
			this.s = compressedString;
		}

		public char next() {
			if (!hasNext()) return ' ';
			if (num == -1) {
				c = s.charAt(idx++);
				int val = 0;
				while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
					val = val * 10 + (s.charAt(idx) - '0');
					idx++;
				}
				num = val;
			}
			num--;
			if (num == 0 && idx < s.length()) num = -1;
			return c;
		}

		public boolean hasNext() {
			return idx < s.length() || num != 0;
		}
	}
}

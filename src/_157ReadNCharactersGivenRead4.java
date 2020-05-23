public class _157ReadNCharactersGivenRead4 {
	private char[] buff = new char[4];
	private int idx = 0;
	public int read(char[] buf, int n) {
		int res = 0;
		while (n > 0) {
			int count = read4(buff);
			for (int i = 0; i < count && i < n; i++) {
				buf[idx++] = buff[i];
				res++;
			}
			if (count == 0) break;
			n -= count;
		}
		return res;
	}

	private int read4(char[] temp) {
		return 1;
	}
}

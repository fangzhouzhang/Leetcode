public class _157ReadNCharactersGivenRead4 {
	public int read(char[] buf, int n) {
		int res = 0;
		char[] buff = new char[4];
		while (res < n) {
			int buffPtr = 0;
			int buffCnt = read4(buff);
			while (res < n && buffPtr < buffCnt) buf[res++] = buff[buffPtr++];
			if (buffCnt < 4) break;
		}
		return res;
	}

	private int read4(char[] temp) {
		return 1;
	}
}

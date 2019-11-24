public class _158ReadNCharactersGivenRead4II {
	private int buffPtr = 0;
	private int buffCnt = 0;
	private char[] buff = new char[4];
	public int read(char[] buf, int n) {
		int res = 0;
		while (res < n) {
			if (buffPtr == 0) buffCnt = read4(buff);
			if (buffCnt == 0) break;
			while (res < n && buffPtr < buffCnt) buf[res++] = buff[buffPtr++];
			if (buffPtr == buffCnt) buffPtr = 0;
		}
		return res;
	}
	private int read4(char[] arr) {
		return 1;
	}
}

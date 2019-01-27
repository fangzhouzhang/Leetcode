public class ReadNCharactersGivenRead4II {
	private int readPos = 0;
	private int valid = 0;
	private char[] temp = new char[4];
	public int read(char[] buf, int n) {
		int writePos = 0;
		int remain = n;
		if (readPos  != 0) {//there is remaining letters need to be copied
			while (readPos < valid && remain > 0) {
				buf[writePos++] = temp[readPos++];
				remain--;
			}
			if (readPos == 4) {
				readPos = 0;
			}

		}
		while (remain > 0) {
			//read 4 chars
			int readNum = read4(temp);
			if (readNum == 4 && remain >= 4) {
				for (; readPos < 4; readPos++) {
					buf[writePos++] = temp[readPos];
					remain--;
				}
				readPos = 0;
			} else if (readNum == 4 && remain < 4) {
				int size = remain;
				for (; readPos < size; readPos++) {
					buf[writePos++] = temp[readPos];
					remain--;
				}
				valid = 4;
			} else if (readNum < 4 && remain >= readNum) {
				for (; readPos < readNum; readPos++) {
					buf[writePos++] = temp[readPos];
					remain--;
				}
				valid = 0;
				readPos = 0;
				break;
			} else if (readNum < 4 && remain < readNum) {
				int size = remain;
				for (; readPos < size; readPos++) {
					buf[writePos++] = temp[readPos];
					remain--;
				}
				valid = readNum;
			}
		}

		return n - remain;

	}
	private int read4(char[] arr) {
		return 1;
	}
}

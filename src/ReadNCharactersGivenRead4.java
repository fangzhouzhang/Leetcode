public class ReadNCharactersGivenRead4 {
	private int readLoc = 0;
	private char[] temp = new char[4];
	public int read(char[] buf, int n) {
		int writeLoc = 0;
		int remain = n;
		while (remain > 0) {
			int readNum = read4(temp);
			if (readNum == 4 && remain >= 4) {
				for (; readLoc < readNum; readLoc++) {
					buf[writeLoc++] = temp[readLoc];
					remain--;
				}
				readLoc = 0;
			} else if (readNum == 4 && remain < 4) {
				int size = remain;
				for (; readLoc < size; readLoc++) {
					buf[writeLoc++] = temp[readLoc];
					remain--;
				}
			} else if (readNum < 4 && remain >= readNum) {
				for (; readLoc < readNum; readLoc++) {
					buf[writeLoc++] = temp[readLoc];
					remain--;
				}
				readLoc = 0;
				break;
			} else if (readNum < 4 && remain < readNum) {
				int size = remain;
				for (; readLoc < size; readLoc++) {
					buf[writeLoc++] = temp[readLoc];
					remain--;
				}
			}
		}
		return n - remain;
	}

	private int read4(char[] temp) {
		return 1;
	}
}

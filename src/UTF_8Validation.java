public class UTF_8Validation {
	public boolean validUtf8(int[] data) {
		int cnt = 0;
		for (int i = 0; i < data.length; i++) {
			if (cnt == 0) {
				if ((data[i] >> 5) == 0b110) {
					cnt = 1;
				} else if ((data[i] >> 4) == 0b1110) {
					cnt = 2;
				} else if ((data[i] >> 3) == 0b11110) {
					cnt = 3;
				} else if ((data[i] >> 7) == 0b01) {
					return false;
				}
			} else {
				if ((data[i] >> 6) == 0b10) {
					cnt--;
				} else {
					return false;
				}
			}
		}
		return cnt == 0;
	}
}

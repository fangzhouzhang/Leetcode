public class MaximumSwap {
	public int maximumSwap(int num) {
		char[] chars = (num + "").toCharArray();
		int[] lastIdx = new int[10];
		for (int i = 0; i < chars.length; i++) {
			lastIdx[chars[i] - '0'] = i;
		}

		for (int i = 0; i < chars.length; i++) {
			for (int j = 9; j > (int)(chars[i] - '0'); j--) {
				if (lastIdx[j] > i) {
					char tmp = chars[i];
					chars[i] = chars[lastIdx[j]];
					chars[lastIdx[j]] = tmp;

					return Integer.valueOf(String.valueOf(chars));
				}
			}
		}
		return num;
	}
}

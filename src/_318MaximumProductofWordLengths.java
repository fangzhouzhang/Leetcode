public class _318MaximumProductofWordLengths {
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0) return 0;
		int n = words.length;
		int[] vals = new int[n];
		for (int i = 0; i < n; i++) {
			String cur = words[i];
			int val = 0;
			for (int j = 0; j < cur.length(); j++) {
				val |= 1 << (cur.charAt(j) - 'a');
			}
			vals[i] = val;
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((vals[i] & vals[j]) != 0) continue;
				max = Math.max(max, words[i].length() * words[j].length());
			}
		}
		return max;
	}
}

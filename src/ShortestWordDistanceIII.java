public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int i1 = -1, i2 = -1, min = Integer.MAX_VALUE;
		boolean same = word1.equals(word2);
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				if (same) {
					i1 = i2;
				} else {
					i1 = i;
				}
			}
			if (words[i].equals(word2)) {
				i2 = i;
			}
			if (i1 != -1 & i2 != -1)
				min = Math.min(min, Math.abs(i1 - i2));
		}
		return min;
	}
}

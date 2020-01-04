public class _809ExpressiveWords {
	public int expressiveWords(String S, String[] words) {
		if (S == null || S.length() == 0 || words == null || words.length == 0) return 0;
		char[] src = S.toCharArray();
		int count = 0;
		for (String word : words) {
			if (isExpWord(src, word.toCharArray())) count++;
		}
		return count;
	}

	private boolean isExpWord(char[] src, char[] word) {
		int srcIdx = 0, srcFast = 0, wordIdx = 0, wordFast = 0;
		while (srcIdx < src.length && wordIdx < word.length) {
			if (src[srcIdx] != word[wordIdx]) return false;
			while (srcFast < src.length && src[srcFast] == src[srcIdx]) srcFast++;
			while (wordFast < word.length && word[wordFast] == word[wordIdx]) wordFast++;
			if (srcFast - srcIdx != wordFast - wordIdx &&
					(srcFast - srcIdx < wordFast - wordIdx || srcFast - srcIdx < 3)) return false;
			srcIdx = srcFast;
			wordIdx = wordFast;
		}
		return srcIdx == src.length && wordIdx == word.length;
	}
}

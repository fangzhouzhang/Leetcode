public class _1455CheckIfaWordOccursAsaPrefixofAnyWordinaSentence {
	public int isPrefixOfWord(String sentence, String searchWord) {
		String[] arr = sentence.split(" ");
		for (int i = 0; i < arr.length; i++) {
			if (search(arr[i], searchWord)) return i + 1;
		}
		return -1;
	}

	private boolean search(String word, String s) {
		if (word.length() < s.length()) return false;
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == word.charAt(i)) i++;
			else return false;
		}
		return true;
	}
}

public class _1832CheckiftheSentenceIsPangram {
	public boolean checkIfPangram(String sentence) {
		if (sentence.length() < 26) return false;
		Integer[] visit = new Integer[26];
		int cnt = 26;
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			int idx = c - 'a';
			if (visit[idx] == null) {
				cnt--;
				visit[idx] = 1;
			}
		}
		return cnt == 0;
	}
}

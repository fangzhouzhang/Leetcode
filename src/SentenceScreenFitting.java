public class SentenceScreenFitting {
	public int wordsTyping(String[] sentence, int rows, int cols) {
		String s = "";
		for (String sen : sentence) {
			s += sen;
			s += " ";
		}
		int count = 0;
		for (int i = 0; i < rows; i++) {
			count += cols;
			if (s.charAt(count % s.length()) == ' ') {
				count++;
			} else {
				while (count > 0 && s.charAt((count - 1) % s.length()) != ' ') {
					count--;
				}
			}
		}
		return count / s.length();
	}
}

public class _1165SingleRowKeyboard {
	public int calculateTime(String keyboard, String word) {
		if (keyboard == null || keyboard.length() == 0 || word == null || word.length() == 0) return 0;
		int[] map = new int[26];
		for (int i = 0; i < keyboard.length(); i++) map[keyboard.charAt(i) - 'a'] = i;
		int cost = 0;
		int prev = 0;
		for (int i = 0; i < word.length(); i++) {
			cost += Math.abs(map[word.charAt(i) - 'a'] - prev);
			prev = map[word.charAt(i) - 'a'];
		}
		return cost;
	}
}

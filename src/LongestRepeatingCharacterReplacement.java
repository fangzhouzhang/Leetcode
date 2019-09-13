public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int max = 0;
		int maxCnt = 0;
		int[] count = new int[26];
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			maxCnt = Math.max(maxCnt, ++count[c - 'A']);
			while (i - start + 1 - maxCnt > k) {
				count[s.charAt(start) - 'A']--;
				start++;
			}
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
}

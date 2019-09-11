public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
		int max = 0;
		//cnt is number character showing up in the string
		for (int cnt = 1; cnt <= 26; cnt++) {
			int uniqueCnt = 0;
			int[] fre = new int[26];
			int start = 0;
			int i = 0;
			while (i < s.length()) {
				boolean valid = true;
				if (fre[s.charAt(i) - 'a']++ == 0) {
					uniqueCnt++;
				}
				while (uniqueCnt > cnt) {
					if (--fre[s.charAt(start) - 'a'] == 0) {
						uniqueCnt--;
					}
					start++;
				}
				for (int num : fre) {
					if (num > 0 && num < k) {
						valid = false;
					}
				}
				if (valid) {
					max = Math.max(max, i - start + 1);
				}
				i++;
			}
		}
		return max;
	}
}

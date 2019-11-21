public class _3LongestSubstringWithoutRepeatingCharacters {
    /**
     * @param s: a string
     * @return: an integer
     * time:o() space:o(n)
     */
	public int lengthOfLongestSubstring(String s) {
		int[] map = new int[128];
		boolean foul = false;
		int slow = 0, fast = 0;
		int max = 0;
		while (fast < s.length()) {
			char c = s.charAt(fast);
			map[c]++;
			if (map[c] > 1) foul = true;
			while (foul) {
				char tmp = s.charAt(slow);
				map[tmp]--;
				if (map[tmp] == 1) foul = false;
				slow++;
			}
			max = Math.max(max, fast - slow + 1);
			fast++;
		}
		return max;
	}
}

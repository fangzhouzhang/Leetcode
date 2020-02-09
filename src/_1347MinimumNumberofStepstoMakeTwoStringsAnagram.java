public class _1347MinimumNumberofStepstoMakeTwoStringsAnagram {
	public int minSteps(String s, String t) {
		int[] map = new int[26];
		for (char c : s.toCharArray()) {
			map[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			map[c - 'a']--;
		}
		int res = 0;
		for (int n : map) {
			res += Math.abs(n);
		}
		return res / 2;
	}
}

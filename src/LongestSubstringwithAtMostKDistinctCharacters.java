public class LongestSubstringwithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int count = 0;
		int[] dict = new int[256];
		int start = 0;
		int max = 0;
		for (int cur = 0; cur < s.length(); cur++) {
			char ch = s.charAt(cur);
			if (dict[ch]++ == 0) {//if cur char frequency 0->1 count++
				count++;
			}
			while (count > k) {
				if (--dict[s.charAt(start++)] == 0) {//if start char frequency 1->0 count--
					count--;
				}
			}
			max = Math.max(max, cur - start + 1);
		}
		return max;

	}
}

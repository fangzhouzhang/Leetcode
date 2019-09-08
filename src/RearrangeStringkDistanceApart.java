public class RearrangeStringkDistanceApart {
	public String rearrangeString(String s, int k) {
		int[] count = new int[26];
		int[] allow = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			count[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int nextIdx = getNextIdx(count, allow, i);
			if (nextIdx == -1) {
				return "";
			}
			allow[nextIdx] = i + k;
			count[nextIdx]--;
			sb.append((char)(nextIdx + 'a'));
		}
		return new String(sb);
	}

	private int getNextIdx(int[] count, int[] allow, int idx) {
		int max = 0;
		int res = -1;
		for (int i = 0; i < 26; i++) {
			if (count[i] > max && idx >= allow[i]) {
				max = count[i];
				res = i;
			}
		}
		return res;
	}
}

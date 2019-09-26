public class PalindromicSubstrings {
	//i = 0 i = 1 i是偶数，从同一个字母向两边扩散，i是奇数，从不同字母向两边扩散
	//l = 0 l = 0
	//r = 0 r = 1
	public int countSubstrings(String s) {
		if (s.length() == 0) return 0;
		int n = s.length() * 2 - 1;
		int res = 0;
		int i = 0;
		while (i <= n) {
			int l = i / 2;
			int r = l + i % 2;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				res++;
				l--;
				r++;
			}
			i++;
		}

		return res;
	}
}

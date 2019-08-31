public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		String p = new StringBuffer(s).reverse().toString();
		char pp[] = p.toCharArray();
		char ss[] = s.toCharArray();
		int m = ss.length;
		if (m == 0) return "";

		// trying to find the greatest overlap of pp[] and ss[]
		// using the buildLPS() method of KMP
		int lps[] = buildLPS(ss);
		int i=0;// points to pp[]
		int len = 0; //points to ss[]

		while(i<m) {
			if (pp[i] == ss[len]) {
				i++;
				len++;
				if (i == m)
					break;
			} else {
				if (len == 0) {
					i++;
				} else {
					len = lps[len-1];
				}
			}
		}
		// after the loop, len is the overlap of the suffix of pp and prefix of ss
		return new String(pp) + s.substring(len, m);

	}

	int [] buildLPS(char ss[]) {
		int m = ss.length;
		int lps[] = new int[m];
		int len = 0;
		int i = 1;
		lps[0] = 0;
		while(i < m) {
			if (ss[i] == ss[len]) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len == 0) {
					i++;
				} else {
					len = lps[len-1];
				}

			}
		}

		return lps;
	}
}

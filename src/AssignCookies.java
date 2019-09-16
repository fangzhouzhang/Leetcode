import java.util.Arrays;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		if (s.length == 0 || g.length == 0) {
			return 0;
		}
		Arrays.sort(g);
		Arrays.sort(s);
		int res = 0;
		int j = 0;
		for (int i = 0; i < g.length; i++) {
			while (j < s.length && s[j] < g[i]) {
				j++;
			}
			if (j == s.length) {
				break;
			}
			if (s[j] >= g[i]) {
				res++;
				j++;
			}
		}
		return res;
	}
}

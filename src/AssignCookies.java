import java.util.Arrays;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		if (s.length == 0 || g.length == 0) {
			return 0;
		}
		Arrays.sort(g);
		Arrays.sort(s);
		int res = 0;
		int i = 0, j = 0;
		while (i < g.length && j < s.length) {
			if (g[i] <= s[j]) {
				i++;
				j++;
				res++;
			} else {
				j++;
			}
		}
		return res;
	}
}

import java.util.ArrayList;
import java.util.List;

public class _1324PrintWordsVertically {
	public List<String> printVertically(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0) return res;
		String[] strs = s.split(" ");
		int len = 0;
		for (String str : strs) len = Math.max(len, str.length());
		for (int i = 0; i < len; i++) {
			StringBuilder sb = new StringBuilder();
			int last = -1;
			for (int j = 0; j < strs.length; j++) {
				if (i < strs[j].length()) {
					sb.append(strs[j].charAt(i));
					last = j;
				}
				else sb.append(" ");
			}
			res.add(new String(sb).substring(0, last + 1));
		}
		return res;
	}
}

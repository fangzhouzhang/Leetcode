import java.util.List;

public class _524LongestWordinDictionarythroughDeleting {
	public String findLongestWord(String s, List<String> d) {
		if (s.length() == 0) return "";
		String res = "";
		for (String str : d) {
			if (containsAllChars(str, s)) {
				if (str.length() == res.length() && str.compareTo(res) < 0) res = str;
				if (str.length() > res.length()) res = str;
			}
		}
		return res;
	}

	private boolean containsAllChars(String a, String target) {
		if (a.length() > target.length()) return false;
		int i = 0, j = 0;
		while (j < target.length()) {
			if (a.charAt(i) == target.charAt(j)) {
				i++;
			}
			j++;
			if (i == a.length()) return true;
		}
		return false;
	}
}

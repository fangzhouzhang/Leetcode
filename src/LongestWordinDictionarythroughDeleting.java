import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {
	public String findLongestWord(String s, List<String> d) {
		if (s.length() == 0) {
			return "";
		}
		Collections.sort(d, new MyComparator());
		for (String str : d) {
			int i = 0;
			for (char c: s.toCharArray()) {
				if (i < str.length() && c == str.charAt(i)) i++;
			}
			if (i == str.length()) return str;
		}
		return "";
	}

	private class MyComparator implements Comparator<String> {
		public int compare(String a, String b) {
			if (a.length() == b.length()) {
				return a.compareTo(b);
			} else {
				return b.length() - a.length();
			}
		}
	}
}

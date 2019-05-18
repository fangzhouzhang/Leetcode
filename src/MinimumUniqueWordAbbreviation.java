import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumUniqueWordAbbreviation {
	public String minAbbreviation(String target, String[] dictionary) {
		if (dictionary.length == 0) {
			return target.length() + "";
		}
		List<String> patterns = getAbbrList(target);

		//sort according to length in patterns
		Collections.sort(patterns, new MyComparator());

		// for (String p : patterns)
		//     System.out.println(p);
		for (String pattern : patterns) {
			boolean isConflict = false;
			for (String dict: dictionary) {
				if (conflict(pattern, dict)) {
					isConflict = true;
					break;
				}
			}
			if (isConflict == false) {
				return pattern;
			}
		}
		return null;
	}
	private boolean conflict(String pattern, String word) {
		int s1 = 0;
		int s2 = 0;
		while (s1 < pattern.length() && s2 < word.length()) {
			if (pattern.charAt(s1) >= '0' && pattern.charAt(s1) <= '9') {
				if (pattern.charAt(s1) == '0') {
					return false;
				} else {
					int prev = 0;
					while (s1 < pattern.length() && pattern.charAt(s1) >= '0' && pattern.charAt(s1) <= '9') {
						int offset = pattern.charAt(s1) - '0';
						prev = prev * 10 + offset;
						s1++;
					}

					//s1++;
					s2 += prev;
				}
			} else {
				if (pattern.charAt(s1) != word.charAt(s2)) {
					return false;
				} else {
					s1++;
					s2++;
				}
			}
		}
		return s1 == pattern.length() && s2 == word.length();
	}
	private class MyComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			//return s1.length() - s2.length();
			int len1 = 0;
			int len2 = 0;
			int idx1 = 0;
			int idx2 = 0;
			while (idx1 < s1.length()) {
				if (s1.charAt(idx1) >= '0' && s1.charAt(idx1) <= '9') {
					while (idx1 < s1.length() && s1.charAt(idx1) >= '0' && s1.charAt(idx1) <= '9') {
						idx1++;
					}
					len1++;
				} else {
					len1++;
					idx1++;
				}
			}
			while (idx2 < s2.length()) {
				if (s2.charAt(idx2) >= '0' && s2.charAt(idx2) <= '9') {
					while (idx2 < s2.length() && s2.charAt(idx2) >= '0' && s2.charAt(idx2) <= '9') {
						idx2++;
					}
					len2++;
				} else {
					idx2++;
					len2++;
				}
			}
			return len1 - len2;
		}
	}
	private List<String> getAbbrList(String target) {
		List<String> patterns = new ArrayList<>();
		dfs(patterns, target, 0, 0, "");
		return patterns;
	}
	private void dfs(List<String> patterns, String target, int idx, int count, String temp) {
		if (idx == target.length() && count == 0) {
			patterns.add(new String(temp));
			return;
		}
		if (idx == target.length() && count != 0) {
			patterns.add(new String(temp + count));
			return;
		}
		if (count == 0) {
			dfs(patterns, target, idx + 1, count, temp + target.charAt(idx));
		} else {
			dfs(patterns, target, idx + 1, 0, temp + count + target.charAt(idx));
		}

		dfs(patterns, target, idx + 1, count + 1, temp);
	}
}

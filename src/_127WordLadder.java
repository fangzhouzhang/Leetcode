import java.util.*;

public class _127WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord == null || endWord == null || wordList == null) return 0;
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord)) return 0;
		Set<String> visit = new HashSet<String>();
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		s1.add(beginWord);
		s2.add(endWord);
		int ret = 1;
		while (s1.size() > 0 && s2.size() > 0) {
			if (s1.size() > s2.size()) {
				Set<String> tmp = s1;
				s1 = s2;
				s2 = tmp;
			}
			Set<String> tmp = new HashSet<>();
			for (String word : s1) {
				char[] chs = word.toCharArray();
				for (int i = 0; i < chs.length; i++) {
					char old = chs[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == old) continue;
						chs[i] = c;
						String change = String.valueOf(chs);
						if (s2.contains(change)) return ret + 1;
						if (!visit.contains(change) && dict.contains(change)) {
							visit.add(change);
							tmp.add(change);
						}
					}
					chs[i] = old;
				}
			}
			ret++;
			s1 = tmp;
		}
		return 0;
	}
}

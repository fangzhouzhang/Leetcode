import java.util.*;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.length() == 0) {
			return 0;
		}
		Set<String> set = new HashSet<>(wordList);
		if (!set.contains(endWord)) {
			return 0;
		}

		Queue<String> q = new LinkedList<>();
		Set<String> dedup = new HashSet<>();
		q.add(beginWord);
		dedup.add(beginWord);
		int step = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String cur = q.poll();
				if (cur.equals(endWord)) {
					return step;
				}

				for (String neigh : wordList) {
					if (isValid(cur, neigh) && dedup.add(neigh)) {
						q.add(neigh);
					}

				}
			}
			step++;
			System.out.println(step);
		}
		return 0;
	}

	// only 1 char change
	private boolean isValid(String beginWord, String endWord) {
		int i = 0;
		int change = 0;
		while (i < beginWord.length()) {
			if (beginWord.charAt(i) != endWord.charAt(i)) {
				change++;
			}
			i++;
		}
		return change == 1 ? true : false;
	}
}

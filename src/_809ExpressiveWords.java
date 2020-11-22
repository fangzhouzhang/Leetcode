import java.util.ArrayList;
import java.util.List;

public class _809ExpressiveWords {
	public int expressiveWords(String S, String[] words) {
		List<Node> ori = new ArrayList<>();

		for (int i = 0; i < S.length(); ) {
			char c = S.charAt(i);
			int fre = 1;
			while (i + 1 < S.length() && S.charAt(i + 1) == S.charAt(i)) {
				i++;
				fre++;
			}
			ori.add(new Node(c, fre));
			i++;
		}

		List<List<Node>> w = new ArrayList<>();
		for (String word: words) {
			List<Node> cur = new ArrayList<>();
			for (int i = 0; i < word.length(); ) {
				char c = word.charAt(i);
				int fre = 1;
				while (i + 1 < word.length() && word.charAt(i + 1) == word.charAt(i)) {
					i++;
					fre++;
				}
				cur.add(new Node(c, fre));
				i++;
			}
			w.add(cur);
		}
		int res = 0;
		for (List<Node> cur : w) {
			if (cur.size() != ori.size()) continue;
			boolean valid = true;
			for (int i = 0; i < cur.size(); i++) {
				if ((cur.get(i).c != ori.get(i).c)
						|| (cur.get(i).fre < ori.get(i).fre && ori.get(i).fre < 3)
						|| (cur.get(i).fre > ori.get(i).fre)) {
					valid = false;
					break;
				}
			}
			if (valid) res++;
		}
		return res;
	}

	private class Node {
		char c;
		int fre;
		public Node(char c, int fre) {
			this.c = c;
			this.fre = fre;
		}
	}
}

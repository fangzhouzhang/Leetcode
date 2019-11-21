import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _642DesignSearchAutocompleteSystem {
	private TrieNode root;
	private TrieNode cur;
	private StringBuilder sb;
	public _642DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode();
		cur = root;
		sb = new StringBuilder();
		for (int i = 0; i < sentences.length; i++) {
			addWord(sentences[i], times[i]);
		}
	}

	private void addWord(String word, int times) {
		List<TrieNode> tmp = new ArrayList<>();
		TrieNode t = root;
		for (char c: word.toCharArray()) {
			if (t.children[c] == null) t.children[c] = new TrieNode();
			t = t.children[c];
			tmp.add(t);
		}
		t.s = word;
		t.times += times;
		for (TrieNode n : tmp) n.update(t);
	}

	public List<String> input(char c) {
		List<String> res = new ArrayList<>();
		if (c == '#') {
			addWord(new String(sb), 1);
			cur = root;
			sb = new StringBuilder();
			return res;
		} else {
			sb.append(c);
			if (cur == null) return res;
			cur = cur.children[c];
			if (cur == null) return res;
			for (TrieNode n : cur.hot) {
				res.add(n.s);
			}
			return res;
		}
	}

	private class TrieNode implements Comparable<TrieNode> {
		private TrieNode[] children;
		private List<TrieNode> hot;
		private String s;
		private int times;
		public TrieNode() {
			children = new TrieNode[128];
			hot = new ArrayList<>();
			times = 0;
			s = null;
		}

		public int compareTo(TrieNode o) {
			if (this.times != o.times) return o.times - this.times;
			return this.s.compareTo(o.s);
		}

		public void update(TrieNode n) {
			if (!this.hot.contains(n)) {
				this.hot.add(n);
			}

			Collections.sort(this.hot);

			if (this.hot.size() > 3) {
				this.hot.remove(this.hot.size() - 1);
			}
		}
	}
}

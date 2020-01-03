public class _1032StreamofCharacters {
	class StreamChecker {
		private TrieNode root;
		private StringBuilder sb;
		public StreamChecker(String[] words) {
			root = new TrieNode();
			sb = new StringBuilder();
			for (String word : words) buildTrie(word);
		}

		public boolean query(char letter) {
			sb.append(letter);
			return search();
		}

		private boolean search() {
			TrieNode cur = root;
			for (int i = sb.length() - 1; i >= 0; i--) {
				if (cur.children[sb.charAt(i) - 'a'] == null) return false;
				cur = cur.children[sb.charAt(i) - 'a'];
				if (cur.isEnd) return true;
			}
			return false;

		}

		private class TrieNode {
			TrieNode[] children;
			boolean isEnd;
			public TrieNode() {
				children = new TrieNode[26];
				isEnd = false;
			}
		}

		private void buildTrie(String str) {
			TrieNode cur = root;
			for (int i = str.length() - 1; i >= 0; i--) {
				if (cur.children[str.charAt(i) - 'a'] == null) cur.children[str.charAt(i) - 'a'] = new TrieNode();
				cur = cur.children[str.charAt(i) - 'a'];
			}
			cur.isEnd = true;
		}
	}
}

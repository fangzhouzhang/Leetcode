public class StreamofCharacters {
	class StreamChecker {
		private TrieNode root;
		private StringBuilder sb;
		public StreamChecker(String[] words) {
			sb = new StringBuilder();
			root = new TrieNode();
			buildTrie(words);
		}

		private void buildTrie(String[] words) {
			for (String s : words) {
				TrieNode cur = root;
				for (int i = s.length() - 1; i >= 0; i--) {
					char c = s.charAt(i);
					if (cur.neighbors[c - 'a'] == null) cur.neighbors[c - 'a'] = new TrieNode();
					cur = cur.neighbors[c - 'a'];
				}
				cur.isWord = true;
			}
		}

		public boolean query(char letter) {
			sb.append(letter);
			TrieNode cur = root;
			for (int i = sb.length() - 1; i >= 0; i--) {
				char c = sb.charAt(i);
				if (cur.neighbors[c - 'a'] == null) return false;
				if (cur.neighbors[c - 'a'] != null && cur.neighbors[c - 'a'].isWord) return true;
				cur = cur.neighbors[c - 'a'];
			}
			return false;
		}

		private class TrieNode{
			TrieNode[] neighbors;
			boolean isWord;
			public TrieNode() {
				neighbors = new TrieNode[26];
				isWord = false;
			}
		}
	}
}

public class _208ImplementTrie {
	class Trie {
		TrieNode root;
		/** Initialize your data structure here. */
		public Trie() {
			root = new TrieNode();

		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			buildTrie(word);
		}

		private void buildTrie(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (cur.neighbors[c - 'a'] == null) cur.neighbors[c - 'a'] = new TrieNode();
				cur = cur.neighbors[c - 'a'];
			}
			cur.end = true;
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (cur.neighbors[c - 'a'] == null) return false;
				cur = cur.neighbors[c - 'a'];
			}
			return cur.end == true;
		}

		/** Returns if there is any word in the trie that starts with the given prefix. */
		public boolean startsWith(String prefix) {
			TrieNode cur = root;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (cur.neighbors[c - 'a'] == null) return false;
				cur = cur.neighbors[c - 'a'];
			}
			return true;
		}

		private class TrieNode {
			TrieNode[] neighbors;
			boolean end;
			public TrieNode() {
				neighbors = new TrieNode[26];
				end = false;
			}
		}
	}

}

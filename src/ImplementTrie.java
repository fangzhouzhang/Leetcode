public class ImplementTrie {
	class Trie {
		private TrieNode node;
		/** Initialize your data structure here. */
		public Trie() {
			node = new TrieNode();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			//PRE: all letter is a to z
			TrieNode cur = node;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (cur.neighbors[ch - 'a'] == null) {
					cur.neighbors[ch - 'a'] = new TrieNode();
					if (i == word.length() - 1) {
						cur.neighbors[ch - 'a'].isWord = true;
					}

				} else {
					if (i == word.length() - 1) {
						cur.neighbors[ch - 'a'].isWord = true;
					}
				}
				cur = cur.neighbors[ch - 'a'];
			}
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			TrieNode cur = node;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (cur.neighbors[ch - 'a'] == null) {
					return false;
				}
				if (i == word.length() - 1 && cur.neighbors[ch - 'a'].isWord == false) {
					return false;
				}
				cur = cur.neighbors[ch - 'a'];
			}
			return true;
		}

		/** Returns if there is any word in the trie that starts with the given prefix. */
		public boolean startsWith(String prefix) {
			TrieNode cur = node;
			for (int i = 0; i < prefix.length(); i++) {
				char ch = prefix.charAt(i);
				if (cur.neighbors[ch - 'a'] == null) {
					return false;
				}
				// if (i == word.length() - 1 && node.neighbors[ch - 'a'].isWord == false) {
				//     return false;
				// }
				cur = cur.neighbors[ch - 'a'];
			}
			return true;
		}
		private class TrieNode {
			private boolean isWord;
			private TrieNode[] neighbors;
			public TrieNode() {
				isWord = false;
				neighbors = new TrieNode[26];
			}
		}
	}

}

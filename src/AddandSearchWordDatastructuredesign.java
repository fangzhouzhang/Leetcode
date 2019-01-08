public class AddandSearchWordDatastructuredesign {
	class WordDictionary {
		private TrieNode node;
		/** Initialize your data structure here. */
		public WordDictionary() {
			node = new TrieNode();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {
			dfs(word, node, 0);
		}

		/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
		public boolean search(String word) {
			if (word == null) {
				return false;
			}
			if (word.length() == 0) {
				return true;
			}
			return searchHelper(word, node, 0);
		}
		private boolean searchHelper(String word, TrieNode node, int level) {
			if (level == word.length()) {
				return true;
			}
			char ch = word.charAt(level);
			if (ch == '.') {
				for (int i = 0; i < 26; i++) {
					if (node.neighbors[i] != null &&
							level != word.length() - 1 &&
							searchHelper(word, node.neighbors[i], level + 1) == true) {
						return true;
					} else if (node.neighbors[i] != null &&
							level == word.length() - 1 &&
							node.neighbors[i].isWord == true) {
						return true;
					}
				}
				return false;
			} else {//ch == 'a' ~ 'z'
				if (node.neighbors[ch - 'a'] == null) {
					return false;
				}
				if (level == word.length() - 1 &&
						node.neighbors[ch - 'a'].isWord == false) {
					return false;
				}
				return searchHelper(word, node.neighbors[ch - 'a'], level + 1);
			}
		}
		private class TrieNode {
			boolean isWord;
			TrieNode[] neighbors;
			public TrieNode() {
				isWord = false;
				neighbors = new TrieNode[26];
			}
		}

		private void dfs(String word, TrieNode node, int level) {
			if (level == word.length()) {
				return;
			}
			char ch = word.charAt(level);
			if (node.neighbors[ch - 'a'] == null) {
				node.neighbors[ch - 'a'] = new TrieNode();
				if (level == word.length() - 1) {
					node.neighbors[ch - 'a'].isWord = true;
				}
			} else {
				if (level == word.length() - 1) {
					node.neighbors[ch - 'a'].isWord = true;
				}
			}
			dfs(word, node.neighbors[ch - 'a'], level + 1);
		}
	}

}

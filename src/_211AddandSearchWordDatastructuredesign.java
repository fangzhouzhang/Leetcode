public class _211AddandSearchWordDatastructuredesign {
	class WordDictionary {
		TrieNode root;
		/** Initialize your data structure here. */
		public WordDictionary() {
			root = new TrieNode();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {
			buildTrie(word);
		}

		/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
		public boolean search(String word) {
			TrieNode cur = root;
			return searchWord(word, 0, cur);
		}

		private boolean searchWord(String word, int idx, TrieNode cur) {
			if (null == cur) return false;
			if (idx == word.length()) return cur.isEnd;
			char c = word.charAt(idx);
			if (c != '.') {
				if (cur.children[c - 'a'] == null) return false;
				return searchWord(word, idx + 1, cur.children[c - 'a']);
			}
			for (int i = 0; i < 26; i++) {
				if (searchWord(word, idx + 1, cur.children[i])) return true;
			}
			return false;
		}

		private void buildTrie(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
				cur = cur.children[idx];
			}
			cur.isEnd = true;
		}

		class TrieNode {
			TrieNode[] children = new TrieNode[26];
			boolean isEnd = false;
			public TrieNode() {

			}
		}
	}
}

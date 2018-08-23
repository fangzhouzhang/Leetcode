public class Trie {
	private TrieNode root;
	public Trie() {
		// do intialization if necessary
		root = new TrieNode();
	}

	/*
	 * @param word: a word
	 * @return: nothing
	 */
	public void insert(String word) {
		// write your code here
		if (search(word)) {
			return;
		}
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.children[c - 'a'] == null) {
				cur.children[c - 'a'] = new TrieNode();
			}
			cur = cur.children[c - 'a'];
		}
		cur.isWord = true;
		return;
	}

	/*
	 * @param word: A string
	 * @return: if the word is in the trie.
	 */
	public boolean search(String word) {
		// write your code here
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.children[c - 'a'] == null) {
				return false;
			}
			cur = cur.children[c - 'a'];
		}
		return cur.isWord;
	}

	/*
	 * @param prefix: A string
	 * @return: if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		// write your code here
		TrieNode cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.children[c - 'a'] == null) {
				return false;
			}
			cur = cur.children[c - 'a'];
		}
		return true;
	}
	class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord = false;
	}
}

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
	private TrieNode root  = new TrieNode();

	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> res = new ArrayList<>();
		if (words.length == 0) {
			return res;
		}
		for (String word : words) {
			insert(word);
		}

		int len = words[0].length();
		List<String> square = new ArrayList<>();
		for (String word : words) {
			square.add(word);
			search(res, square, len);
			square.remove(word);
		}
		return res;
	}

	private void search(List<List<String>> res, List<String> square, int len) {
		if (square.size() == len) {
			res.add(new ArrayList<>(square));
			return;
		}
		String prefix = getPrefix(square, square.size());
		TrieNode node = getTrieNode(prefix);
		if (node == null) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		List<String> children = new ArrayList<>();
		getChildren(node, sb, children);
		for (String child : children) {
			square.add(child);
			search(res, square, len);
			square.remove(square.size() - 1);
		}
	}

	private String getPrefix(List<String> square, int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(square.get(i).charAt(len));
		}
		return new String(sb);
	}

	/** Inserts a word into the trie. */
	private void insert(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.neighbors[c - 'a'] == null) {
				cur.neighbors[c - 'a'] = new TrieNode();
			}
			if (i == word.length() - 1) {
				cur.neighbors[c - 'a'].isWord = true;
			}
			cur = cur.neighbors[c - 'a'];
		}
	}

	private TrieNode getTrieNode(String prefix) {
		TrieNode cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			int idx = prefix.charAt(i) - 'a';
			if (cur.neighbors[idx] == null) {
				return null;
			}
			cur = cur.neighbors[idx];
		}
		return cur;
	}

	private void getChildren(TrieNode node, StringBuilder sb, List<String> res) {
		if (node.isWord) {
			res.add(new String(sb));
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (node.neighbors[i] != null) {
				int prev = sb.length();
				sb.append((char)(i + 'a'));
				getChildren(node.neighbors[i], sb, res);
				sb.setLength(prev);
			}
		}
	}

	private class TrieNode {
		TrieNode[] neighbors;
		boolean isWord;
		TrieNode() {
			neighbors = new TrieNode[26];
			isWord = false;
		}
	}
}

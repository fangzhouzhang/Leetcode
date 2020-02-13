import java.util.*;

public class _720LongestWordinDictionary {
	private TrieNode root;
	public String longestWord(String[] words) {
		if (words == null || words.length == 0) return "";
		root = new TrieNode();
		Map<Integer, Set<String>> map = new HashMap<>();
		for (String word : words) {
			if (!map.containsKey(word.length())) map.put(word.length(), new HashSet<>());
			map.get(word.length()).add(word);
		}
		if (map.get(1) == null || map.get(1).size() == 0) return "";
		LinkedList<String> list = new LinkedList<>();
		for (String word : map.get(1)) {
			buildBaseTrie(word);
			list.addFirst(word);
		}
		int lastWordLength = 1;
		while (map.get(lastWordLength + 1) != null && map.get(lastWordLength + 1).size() != 0) {
			Set<String> dicts = map.get(lastWordLength + 1);
			for (String word : dicts) {
				if (buildTrie(word)) list.addFirst(word);
			}
			lastWordLength++;
		}
		Collections.sort(list, new MyComparator());
		return list.getFirst();
	}

	private boolean buildTrie(String word) {
		TrieNode cur = root;
		char[] arr = word.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (i != arr.length - 1 && cur.children[c - 'a'] == null) return false;
			if (i == arr.length - 1 && cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
			cur = cur.children[c - 'a'];
		}
		return true;
	}

	private void buildBaseTrie(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
		}
	}

	private class TrieNode {
		TrieNode[] children;
		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	private class MyComparator implements Comparator<String> {
		public int compare(String a, String b) {
			if (a.length() != b.length()) {
				return b.length() - a.length();
			} else {
				return a.compareTo(b);
			}
		}
	}
}

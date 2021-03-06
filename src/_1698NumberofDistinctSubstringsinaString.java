public class _1698NumberofDistinctSubstringsinaString {
	class Trie {
		Trie[] children;
		public Trie() {
			children = new Trie[26];
		}
	}

	public int countDistinct(String s) {
		if (s == null || s.length() == 0) return 0;
		int n = s.length(), res = 0;
		Trie root = new Trie();
		for (int i = 0; i < n; i++) {
			Trie cur = root;
			for (int j = i; j < n; j++) {
				int idx = s.charAt(j) - 'a';
				if (cur.children[idx] == null) {
					cur.children[idx] = new Trie();
					res++;
				}
				cur = cur.children[idx];
			}
		}
		return res;
	}
}

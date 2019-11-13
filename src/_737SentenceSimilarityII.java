import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _737SentenceSimilarityII {
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
		if (words1.length != words2.length) return false;
		Map<String, Integer> map = new HashMap<>();
		setIndices(map, pairs);
		UnionFind uf = new UnionFind(map.size());
		for (List<String> pair : pairs) {
			String word1 = pair.get(0);
			String word2 = pair.get(1);
			int a = map.get(word1);
			int b = map.get(word2);
			uf.union(a, b);
		}
		for (int i = 0; i < words1.length; i++) {
			if (words1[i].equals(words2[i])) continue;
			Integer a = map.get(words1[i]);
			Integer b = map.get(words2[i]);
			if (a == null || b == null) return false;
			if (uf.find(a) != uf.find(b)) return false;
		}
		return true;
	}

	private void setIndices(Map<String, Integer> map, List<List<String>> pairs) {
		int idx = 0;
		for (List<String> pair : pairs) {
			for (String word : pair) {
				if (!map.containsKey(word)) {
					map.put(word, idx++);
				}
			}
		}
	}

	private class UnionFind {
		int[] parent;
		int[] rank;
		public UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) parent[i] = i;
			rank = new int[n];
		}

		private int find(int x) {
			if (x != parent[x]) parent[x] = find(parent[x]);
			return parent[x];
		}

		private void union(int a, int b) {
			int roota = find(a);
			int rootb = find(b);

			if (roota == rootb) return;

			if (rank[roota] > rank[rootb]) parent[rootb] = roota;
			else if (rank[roota] < rank[rootb]) parent[roota] = rootb;
			else {
				parent[rootb] = roota;
				rank[roota]++;
			}
		}
	}
}

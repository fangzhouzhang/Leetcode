public class _684RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
		if (edges == null || edges.length == 0) return new int[0];
		UnionFind uf = new UnionFind(edges.length + 1);
		for (int[] e : edges) {
			int u = e[0];
			int v = e[1];
			uf.init(u);
			uf.init(v);
			if (uf.getParent(u) != 0 && uf.getParent(u) == uf.getParent(v)) {
				return e;
			}
			uf.union(u, v);
		}
		return null;
	}

	private class UnionFind {
		private int[] parents;
		private int[] rank;
		public UnionFind(int n) {
			parents = new int[n];
			rank = new int[n];
		}

		public void init(int x) {
			if (parents[x] == 0) {
				parents[x] = x;
				rank[x] = 1;
			}
		}
		public int getParent(int x) {
			if (parents[x] == x) return x;
			return parents[x] = getParent(parents[x]);
		}

		public void union(int a, int b) {
			int rootA = getParent(a);
			int rootB = getParent(b);
			if (rootA != 0 && rootA == rootB) return;
			if (rank[rootA] > rank[rootB]) {
				parents[rootB] = rootA;
			} else if (rank[rootA] < rank[rootB]) {
				parents[rootA] = rootB;
			} else {
				parents[rootA] = rootB;
				rank[rootB]++;
			}
		}
	}
}

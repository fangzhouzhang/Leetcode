public class _1579RemoveMaxNumberofEdgestoKeepGraphFullyTraversable {
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		UnionFind a = new UnionFind(n + 1);
		UnionFind b = new UnionFind(n + 1);
		int res = 0;
		for (int[] e : edges) {
			if (e[0] != 3) continue;
			res += a.union(e[1], e[2]);
			b.union(e[1], e[2]);
		}
		for (int[] e : edges) {
			if (e[0] == 3) continue;
			if (e[0] == 1) res += a.union(e[1], e[2]);
			if (e[0] == 2) res += b.union(e[1], e[2]);
		}
		return (a.edges == n - 1 && b.edges == n - 1) ?
				res : -1;
	}

	private class UnionFind {
		int[] parent;
		int[] rank;
		int edges;
		public UnionFind(int n) {
			edges = 0;
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
			rank = new int[n];
			for (int i = 0; i < n; i++) {
				rank[i] = 1;
			}
		}

		public int getParent(int x) {
			if (parent[x] == x) return x;
			return parent[x] = getParent(parent[x]);
		}

		public int union(int a, int b) {
			int rootA = getParent(a);
			int rootB = getParent(b);
			if (rootA == rootB) return 1;
			if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
			} else if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
			} else {
				parent[rootA] = rootB;
				rank[rootB]++;
			}
			edges++;
			return 0;
		}
	}
}

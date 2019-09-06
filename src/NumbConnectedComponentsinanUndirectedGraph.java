import java.util.Arrays;

public class NumbConnectedComponentsinanUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			if (!uf.isIsland(edge[0])) {
				uf.createIsland(edge[0]);
			}
			if (!uf.isIsland(edge[1])) {
				uf.createIsland(edge[1]);
			}
			if (!uf.find(edge[0], edge[1])) {
				uf.union(edge[0], edge[1]);
			}

		}
		int rem = uf.getRem();
		return uf.num + rem;
	}
	private class UnionFind {
		private int[] parent;
		private int[] size;
		public int num;
		public UnionFind(int n) {
			parent = new int[n];
			size = new int[n];
			Arrays.fill(parent, -1);
		}

		public boolean find(int idx1, int idx2) {
			return root(idx1) == root(idx2);
		}

		public void union(int idx1, int idx2) {
			int r1 = root(idx1);
			int r2 = root(idx2);
			if (r1 == r2) {
				return ;
			}
			if (size[r1] < size[r2]) {
				parent[r1] = r2;
				size[r2] += size[r1];
			} else {
				parent[r2] = r1;
				size[r1] += size[r2];
			}
			this.num--;
		}

		public int root(int idx) {
			int cur = idx;
			while (parent[cur] != cur) {
				parent[cur] = parent[parent[cur]];
				cur = parent[cur];
			}
			parent[idx] = cur;
			return cur;
		}

		public boolean isIsland(int idx) {
			return parent[idx] >= 0;
		}

		public void createIsland(int idx) {
			size[idx] = 1;
			parent[idx] = idx;
			this.num++;
		}

		public int getRem() {
			int rem = 0;
			for (int num : parent) {
				if (num == -1) {
					rem++;
				}
			}
			return rem;
		}
	}
}

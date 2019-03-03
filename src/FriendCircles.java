import java.util.Arrays;

public class FriendCircles {
	public int findCircleNum(int[][] M) {
		UnionFind uf = new UnionFind(M.length, M.length);
		for (int offset = 1; offset < M.length; offset++) {
			for (int i = 0; i + offset < M.length; i++) {
				if (M[i][i + offset] == 0) {
					continue;
				}
				uf.union(i, i + offset);
			}
		}
		return uf.num;
	}
	private class UnionFind {
		private int[] parent;
		private int[] size;
		private int num;
		public UnionFind(int m , int n) {
			parent = new int[m];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;

			}
			size = new int[m];
			Arrays.fill(size, 1);
			num = n;
		}
		private int root(int idx) {
			int cur = idx;
			while (parent[cur] != cur) {
				parent[cur] = parent[parent[cur]];
				cur = parent[cur];
			}
			parent[idx] = cur;
			return cur;
		}
		private boolean find(int i1, int i2) {
			return root(i1) == root(i2);
		}
		private void union(int i1, int i2) {
			if (find(i1, i2) == true) {
				return;
			}
			int r1 = root(i1);
			int r2 = root(i2);
			if (size[r1] >= size[r2]) {
				//r1 is root
				parent[r2] = r1;
				size[r1] += size[r2];
			} else {
				parent[r1] = r2;
				size[r2] += size[r1];
			}
			num--;
		}
	}
}

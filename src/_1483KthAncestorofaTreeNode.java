import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1483KthAncestorofaTreeNode {
	class TreeAncestor {

		private int[][] map;

		public TreeAncestor(int n, int[] parent) {
			map = new int[n + 1][log2(n) + 1];
			for (int i = 0; i < n; i++) {
				Arrays.fill(map[i], -1);
			}
			for (int i = 0; i < n; i++) {
				map[i][0] = parent[i];
			}
			List[] g = new List[n];
			for (int i = 0; i < n; i++) {
				g[i] = new ArrayList<>();
			}
			for (int i = 1; i < n; i++) {
				g[parent[i]].add(i);
			}
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			while (!q.isEmpty()) {
				int cur = q.poll();
				List<Integer> list = g[cur];
				for (int nei: list) {
					for (int i = 1; i < map[0].length; i++ ) {
						map[nei][i] = map[map[nei][i - 1]][i - 1];
						if (map[nei][i] == -1) break;
					}
					q.add(nei);
				}
			}
		}

		public int log2(int N)
		{

			// calculate log2 N indirectly
			// using log() method
			int result = (int)(Math.ceil(Math.log(N) / Math.log(2)));

			return result;
		}

		public int getKthAncestor(int node, int k) {
			for (int i = 0; i < map[node].length; i++) {
				if (((k >> i) & 1) == 1) {
					node = map[node][i];
					if (node == -1) return node;
				}
			}
			return node;
		}
	}
}

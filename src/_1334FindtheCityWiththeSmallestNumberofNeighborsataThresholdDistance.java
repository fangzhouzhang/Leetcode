import java.util.Arrays;

public class _1334FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		if (edges == null || edges.length == 0) return 0;
		long[][] es = new long[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(es[i], Integer.MAX_VALUE);
		for (int i = 0; i < n; i++) es[i][i] = 0;
		for (int[] e : edges) {
			es[e[0]][e[1]] = e[2];
			es[e[1]][e[0]] = e[2];
		}

		for (int t = 0; t < n; t++) {
			for (int v = 0; v < n; v++) {
				for (int w = 0; w < n; w++) {
					if (es[v][t] + es[t][w] < es[v][w]) es[v][w] = es[v][t] + es[t][w];
				}
			}
		}
		int minNeighbors = Integer.MAX_VALUE, res = -1;
		for (int v = 0; v < n; v++) {
			int count = 0;
			for (int w = 0; w < n; w++) {
				if (es[v][w] <= distanceThreshold) count++;
			}
			if (count <= minNeighbors) {
				minNeighbors = count;
				res = v;
			}
		}
		return res;
	}
}

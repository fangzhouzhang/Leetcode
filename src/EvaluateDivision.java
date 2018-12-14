import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, Map<String, Double>> map = buildMap(equations, values);
		//printMap(map);
		double[] res = new double[queries.length];
		fillRes(map, queries, res);
		return res;
	}
	private Map<String, Map<String, Double>> buildMap(String[][] equations, double[] values) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			if (map.containsKey(equations[i][0])) {
				Map<String, Double> neigh1 = map.get(equations[i][0]);
				neigh1.put(equations[i][1], values[i]);
			} else {
				Map<String, Double> neigh1 = new HashMap<>();
				neigh1.put(equations[i][1], values[i]);
				map.put(equations[i][0], neigh1);
			}

			if (map.containsKey(equations[i][1])) {
				Map<String, Double> neigh1 = map.get(equations[i][1]);
				neigh1.put(equations[i][0], 1.0 / values[i]);
			} else {
				Map<String, Double> neigh1 = new HashMap<>();
				neigh1.put(equations[i][0], 1.0 / values[i]);
				map.put(equations[i][1], neigh1);
			}
		}
		return map;
	}
	private void printMap(Map<String, Map<String, Double>> map) {
		for (String key: map.keySet()) {
			Map<String, Double> neighs = map.get(key);
			for (String neigh: neighs.keySet())
				System.out.println("key is " + key + " neigh key is " + neigh + " weight is " + neighs.get(neigh));
		}
	}
	private void fillRes(Map<String, Map<String, Double>> map,
						 String[][] queries,
						 double[] res) {
		for (int i = 0; i < res.length; i++) {
			if (!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1])) {
				res[i] = -1.0;
				continue;
			}
			if (queries[i][0].equals(queries[i][1])) {
				res[i] = 1.0;
				continue;
			}
			Set<String> set = new HashSet<String>();
			helper(map, queries, res, i, set, 1, queries[i][0]);
		}
	}
	private void helper(Map<String, Map<String, Double>> map,
						String[][] queries,
						double[] res,
						int i,
						Set<String> set,
						double product,
						String str) {
		if (set.contains(queries[i][0]) && set.contains(queries[i][1])) {
			res[i] = product;
			// System.out.println("i is " + i + " res[i] " + res[i]);
			return;
		}
		set.add(str);
		Map<String, Double> neighs = map.get(str);
		for (String neigh: neighs.keySet()) {
			if (set.contains(neigh)) {
				continue;
			}
			set.add(neigh);
			helper(map, queries, res, i, set, product * neighs.get(neigh), neigh);
			set.remove(neigh);
		}
		if (res[i] == 0) {
			res[i] = -1.0;
		}
		set.remove(str);
	}
}

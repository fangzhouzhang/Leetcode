import java.util.*;

public class _399EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		double[] res = new double[queries.size()];
		Map<String, Double> cache = new HashMap<>();
		Map<String, Map<String, Double>> map = buildGraph(equations, values, cache);
		Set<String> set = new HashSet<>();
		int idx = 0;
		for (List<String> q : queries) {
			String first = q.get(0);
			String second = q.get(1);
			set.add(first);
			if (!map.containsKey(first) || !map.containsKey(second)) {
				res[idx] = -1.0;
			} else {
				double ans = dfs(map, first, second, res, cache, set);
				res[idx] = ans > 0 ? ans : -1.0;
			}
			set.remove(first);
			idx++;
		}
		return res;
	}

	private double dfs(Map<String, Map<String, Double>> map, String start, String end, double[] res, Map<String, Double> cache, Set<String> set) {
		if (start.equals(end)) return 1.0;
		String key = start + "#" + end;
		if (cache.get(key) != null) return cache.get(key);

		Map<String, Double> neighbors = map.get(start);
		for (Map.Entry<String, Double> e : neighbors.entrySet()) {
			String nei = e.getKey();
			double val = e.getValue();
			if (set.contains(nei)) continue;
			set.add(nei);
			double cur = dfs(map, nei, end, res, cache, set);
			if (cur > 0) {
				cache.put(key, cur * val);
				set.remove(nei);
				return cur * val;
			}
			set.remove(nei);
		}
		cache.put(key, -1.0);
		return -1.0;
	}

	private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values, Map<String, Double> cache) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		int idx = 0;
		for (List<String> eq : equations) {
			String first = eq.get(0);
			String second = eq.get(1);
			cache.put(first + "#" + second, values[idx]);
			cache.put(second + "#" + first, (1.0 /values[idx]));
			if (!map.containsKey(first)) {
				map.put(first, new HashMap<String, Double>());
			}
			map.get(first).put(second, values[idx]);
			if (!map.containsKey(second)) {
				map.put(second, new HashMap<String, Double>());
			}
			map.get(second).put(first, (1.0 / values[idx]));
			idx++;
		}
		return map;
	}
}

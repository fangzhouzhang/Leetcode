import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class _1396DesignUndergroundSystem {
	class UndergroundSystem {
		Map<List<String>, long[]> map;
		Map<Integer, Stack<Pair>> p;
		public UndergroundSystem() {
			map = new HashMap<>();
			p = new HashMap<>();
		}

		public void checkIn(int id, String stationName, int t) {
			if (!p.containsKey(id)) {
				p.put(id, new Stack<>());
			}
			p.get(id).push(new Pair(stationName, t));
		}

		public void checkOut(int id, String stationName, int t) {
			Pair in = p.get(id).pop();
			List<String> key = Collections.unmodifiableList(Arrays.asList(in.station, stationName));
			if (!map.containsKey(key)) {
				map.put(key, new long[2]);
			}
			map.get(key)[0] += t - in.t;
			map.get(key)[1] += 1;
		}

		public double getAverageTime(String startStation, String endStation) {
			List<String> key = Collections.unmodifiableList(Arrays.asList(startStation, endStation));
			return map.get(key)[0] * 1.0 / map.get(key)[1];
		}

		private class Pair {
			String station;
			int t;
			public Pair(String station, int t) {
				this.station = station;
				this.t = t;
			}
		}
	}
}

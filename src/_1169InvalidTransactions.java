import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1169InvalidTransactions {
	public List<String> invalidTransactions(String[] transactions) {
		List<String> res = new ArrayList<>();
		if (transactions == null || transactions.length == 0) return res;
		int n = transactions.length;
		Map<String, List<Pair>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] trans = transactions[i].split(",");
			if (!map.containsKey(trans[0])) map.put(trans[0], new ArrayList<>());
			map.get(trans[0]).add(new Pair(Integer.valueOf(trans[1]), trans[3], Integer.valueOf(trans[2]), i));
		}
		boolean[] add = new boolean[n];
		for (Map.Entry<String, List<Pair>> e: map.entrySet()) {
			Collections.sort(e.getValue(), new MyComparator());
			List<Pair> ps = e.getValue();
			int sz = ps.size();
			for (int i = 0; i < sz; i++) {
				if (ps.get(i).money > 1000) {
					add[ps.get(i).idx] = true;
					// continue;
				}
				for (int j = i + 1; j < sz && ps.get(j).time - ps.get(i).time <= 60; j++) {
					if (!ps.get(i).loc.equals(ps.get(j).loc)) {
						add[ps.get(i).idx] = true;
						add[ps.get(j).idx] = true;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (add[i]) res.add(transactions[i]);
		}
		return res;
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return a.time - b.time;
		}
	}

	private class Pair {
		int time;
		int idx;
		String loc;
		int money;
		public Pair(int time, String loc, int money, int idx) {
			this.time = time;
			this.money = money;
			this.loc = loc;
			this.idx = idx;
		}
	}
}

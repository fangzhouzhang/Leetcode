import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class _1606FindServersThatHandledMostNumberofRequests {
	public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
		List<Integer> res = new ArrayList<>();
		if (arrival == null || arrival.length == 0) return res;
		int n = arrival.length;
		TreeSet<Integer> availableServers = new TreeSet<>();
		for (int i = 0; i < k; i++) availableServers.add(i);
		PriorityQueue<int[]> busyServers = new PriorityQueue<>((x, y) -> x[0] - y[0]);
		int[] servers = new int[k];
		int max = 0;
		for (int i = 0; i < n; i++) {
			while (!busyServers.isEmpty() && busyServers.peek()[0] <= arrival[i]) {
				availableServers.add(busyServers.poll()[1]);
			}
			if (availableServers.size() == 0) continue;
			Integer serverIdx = availableServers.ceiling((i % k));
			if (serverIdx == null) {
				serverIdx = availableServers.first();
			}
			availableServers.remove(serverIdx);
			busyServers.add(new int[]{arrival[i] + load[i], serverIdx});
			servers[serverIdx]++;
			max = Math.max(servers[serverIdx], max);
		}
		for (int i = 0; i < k; i++) {
			if (servers[i] == max) {
				res.add(i);
			}
		}
		return res;
	}
}

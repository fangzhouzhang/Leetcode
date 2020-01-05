import java.util.*;

public class _1311GetWatchedVideosbyYourFriends {
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		List<String> res = new ArrayList<>();
		if (watchedVideos == null || watchedVideos.size() == 0 || friends == null || friends.length == 0) return res;
		Map<String, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		int k = 0;
		boolean arriveLevel = false;
		q.add(id);
		set.add(id);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if (k == level) {
					arriveLevel = true;
					List<String> videos = watchedVideos.get(cur);
					for (String video : videos) {
						map.put(video, map.getOrDefault(video, 0) + 1);
					}
				}
				if (!arriveLevel) {
					for (int f : friends[cur]) {
						if (!set.contains(f)) {
							set.add(f);
							q.add(f);
						}
					}
				}
			}
			if (arriveLevel) break;
			k++;
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());
		for (Map.Entry<String, Integer> e: map.entrySet()) pq.add(new Pair(e.getKey(), e.getValue()));
		while (!pq.isEmpty()) res.add(pq.poll().name);
		return res;
	}

	private class MyComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			if (a.fre != b.fre) return a.fre - b.fre;
			else return a.name.compareTo(b.name);
		}
	}

	private class Pair {
		String name;
		int fre;
		public Pair(String name, int fre) {
			this.name = name;
			this.fre = fre;
		}
	}
}

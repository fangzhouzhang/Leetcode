import java.util.*;

public class _1348TweetCountsPerFrequency {
	private class TweetCounts {
		private int MINUTE = 60;
		private int HOUR = 3600;
		private int DAY = 86400;
		Map<String, TreeMap<Integer, Integer>> map;
		public TweetCounts() {
			map = new HashMap<>();
		}

		public void recordTweet(String tweetName, int time) {
			if (!map.containsKey(tweetName)) map.put(tweetName, new TreeMap<>());
			TreeMap<Integer, Integer> tmap = map.get(tweetName);
			tmap.put(time, tmap.getOrDefault(time, 0) + 1);
		}

		public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
			List<Integer> res = new ArrayList<>();
			if (!map.containsKey(tweetName)) return res;
			TreeMap<Integer, Integer> tmap = map.get(tweetName);
			int interval = 0;
			if (freq.equals("minute")) interval = MINUTE;
			else if (freq.equals("hour")) interval = HOUR;
			else if (freq.equals("day")) interval = DAY;

			int size = (endTime - startTime) / interval + 1;

			int[] tmp = new int[size];
			for (Map.Entry<Integer, Integer> e : tmap.subMap(startTime, endTime + 1).entrySet()) {
				int idx = (e.getKey() - startTime) / interval;
				tmp[idx] += e.getValue();
			}
			for (int n : tmp) res.add(n);
			return res;
		}
	}
}

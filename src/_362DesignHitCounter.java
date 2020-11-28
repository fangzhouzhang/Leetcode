public class _362DesignHitCounter {
	private class HitCounter {
		private int[] hits;
		private int[] ts;

		/** Initialize your data structure here. */
		public HitCounter() {
			hits = new int[300];
			ts = new int[300];
		}

		/** Record a hit.
		 @param timestamp - The current timestamp (in seconds granularity). */
		public void hit(int timestamp) {
			int idx = timestamp % 300;
			if (ts[idx] != timestamp) {
				hits[idx] = 1;
				ts[idx] = timestamp;
			} else {
				hits[idx]++;
			}
		}

		/** Return the number of hits in the past 5 minutes.
		 @param timestamp - The current timestamp (in seconds granularity). */
		public int getHits(int timestamp) {
			int res = 0;
			for (int i = 0; i < 300; i++) {
				if (timestamp - ts[i] < 300) res += hits[i];
			}
			return res;
		}
	}

}

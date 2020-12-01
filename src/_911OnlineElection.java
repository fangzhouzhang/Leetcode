import java.util.HashMap;
import java.util.Map;

public class _911OnlineElection {
	private class TopVotedCandidate {

		private Map<Integer, Integer> time_lead;
		private Map<Integer, Integer> lead_votes;
		private int n;
		private int[] time;


		public TopVotedCandidate(int[] persons, int[] times) {
			time = times;
			time_lead = new HashMap<>();
			lead_votes = new HashMap<>();
			int prevLead = -1;
			n = persons.length;
			for (int i = 0; i < n; i++) {
				int curPerson = persons[i];
				int curTime = times[i];
				lead_votes.put(curPerson, lead_votes.getOrDefault(curPerson, 0) + 1);
				if (i == 0 || lead_votes.get(prevLead) <= lead_votes.get(curPerson)) {
					prevLead = curPerson;
				}
				time_lead.put(curTime, prevLead);
			}
		}

		public int q(int t) {
			// find the largest idx <= t
			int idx = bs(t);
			return (idx == -1 || idx >= n) ? -1 : time_lead.get(time[idx]);
		}

		private int bs(int t) {
			int start = 0, end = n - 1;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				if (time[mid] == t) return mid;
				if (time[mid] < t) start = mid + 1;
				else end = mid - 1;
			}
			return end;
		}
	}
}

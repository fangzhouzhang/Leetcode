import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
	public Map<Integer, Double> highFive(Record[] results) {
		// Write your code here
		Map<Integer, Double> map = new HashMap<>();
		Map<Integer, PriorityQueue<Integer>> grades = new HashMap<>();
		for (Record result: results) {
			if (grades.containsKey(result.id)) {
				PriorityQueue<Integer> pq = grades.get(result.id);
				if (pq.size() < 5) {
					pq.add(result.score);
				} else {
					if (pq.peek() < result.score) {
						pq.poll();
						pq.add(result.score);
						grades.put(result.id, pq);
					}
				}

			} else {
				grades.put(result.id, new PriorityQueue<Integer>(5));
				PriorityQueue<Integer> pq = grades.get(result.id);
				pq.add(result.score);
				grades.put(result.id, pq);
			}
		}

		for (Integer key: grades.keySet()) {
			double avg = 0.0;
			PriorityQueue<Integer> pq = grades.get(key);
			int sum = 0;
			while (!pq.isEmpty()) {
				sum += pq.poll();
			}
			avg = sum * 1.0 / 5;
			map.put(key, avg);
		}
		return map;
	}
	private class Record {
		public int id, score;
		public Record(int id, int score){
			this.id = id;
			this.score = score;
		}
	}
}

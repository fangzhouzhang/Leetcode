import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
	public int minMutation(String start, String end, String[] bank) {
		Set<String> dict = new HashSet<>();
		for (String s: bank) {
			dict.add(s);
		}
		if (!dict.contains(end)) {
			return -1;
		}
		char[] chars = new char[]{'A', 'C', 'G', 'T'};
		Queue<String> q = new LinkedList<>();
		Set<String> dedup = new HashSet<>();
		dedup.add(start);
		q.offer(start);
		int min = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String s = q.poll();
				if (s.equals(end)) {
					return min;
				}
				char[] arr = s.toCharArray();
				for (int j = 0; j < arr.length; j++) {
					char old = arr[j];
					for (char c : chars) {
						arr[j] = c;
						String tmp = new String(arr);
						if (!dedup.contains(tmp) && dict.contains(tmp)) {
							q.offer(tmp);
							dedup.add(tmp);
						}
					}
					arr[j] = old;
				}
			}
			min++;
		}
		return -1;
	}
}

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _752OpentheLock {
	public int openLock(String[] deadends, String target) {
		Queue<String> q = new LinkedList<>();
		q.add("0000");
		Set<String> set = new HashSet<>();
		set.add("0000");
		Set<String> dead = new HashSet<>();
		for (String d: deadends) dead.add(d);
		if (dead.contains("0000")) return -1;
		int res = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String cur = q.poll();
				if (target.equals(cur)) return res;
				// generate next
				char[] arr = cur.toCharArray();
				for (int k = 0; k < 4; k++) {
					char old = arr[k];
					arr[k] = (char)((arr[k] - '0' + 9) % 10 + '0');
					String next = new String(arr);
					if (!set.contains(next) && !dead.contains(next)) {
						set.add(next);
						q.add(next);
					}
					arr[k] = old;
				}
				for (int k = 0; k < 4; k++) {
					char old = arr[k];
					arr[k] = (char)((arr[k] - '0' + 1) % 10 + '0');;
					String next = new String(arr);
					if (!set.contains(next) && !dead.contains(next)) {
						set.add(next);
						q.add(next);
					}
					arr[k] = old;
				}
			}
			res++;
		}
		return -1;
	}
}

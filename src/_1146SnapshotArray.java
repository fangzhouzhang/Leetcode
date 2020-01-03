import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1146SnapshotArray {
	class SnapshotArray {
		private Map[] snaps;
		private int count;
		private int[] data;
		private Set<Integer> existIdx;
		public SnapshotArray(int length) {
			snaps = new Map[length];
			data = new int[length];
			existIdx = new HashSet<>();
			count = 0;
		}

		public void set(int index, int val) {
			data[index] = val;
			existIdx.add(index);
		}

		public int snap() {
			count++;
			for (int idx: existIdx) {
				if (snaps[idx] == null) snaps[idx] = new HashMap<Integer, Integer>();
				snaps[idx].put(count - 1, data[idx]);
			}

			return count - 1;
		}

		public int get(int index, int snap_id) {
			if (snaps[index] == null || !snaps[index].containsKey(snap_id)) return 0;
			return (int)snaps[index].get(snap_id);
		}
	}
}

import java.util.ArrayList;
import java.util.List;

public class _1146SnapshotArray {
	class SnapshotArray {
		int snapVersion = 0;
		List<int[]>[] lists;

		public SnapshotArray(int length) {
			lists = new List[length];
			for (int i = 0; i < length; i++) {
				lists[i] = new ArrayList<int[]>();
				lists[i].add(new int[]{0, 0});
			}
		}

		public void set(int index, int val) {
			List<int[]> list = lists[index];
			int n = list.size();
			if (list.get(n - 1)[0] == snapVersion) list.get(n - 1)[1] = val;
			else {
				list.add(new int[]{snapVersion, val});
			}
		}

		public int snap() {
			return snapVersion++;
		}

		public int get(int index, int snap_id) {
			List<int[]> list = lists[index];
			int l = 0, r = list.size() - 1;
			while (l < r) {
				int mid = l + r + 1>> 1;
				int[] a = list.get(mid);
				if (a[0] <= snap_id) l = mid;
				else r = mid - 1;
			}
			return list.get(l)[1];
		}
	}
}

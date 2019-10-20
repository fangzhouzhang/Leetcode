import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapshotArray {
	private List<TreeMap<Integer, Integer>> lists;
	private int snapId;
	public SnapshotArray(int length) {
		lists = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			lists.add(new TreeMap<>());
			lists.get(i).put(0, 0);
		}
		snapId = 0;
	}

	public void set(int index, int val) {
		lists.get(index).put(snapId, val);
	}

	public int snap() {
		return snapId++;
	}

	public int get(int index, int snap_id) {
		return lists.get(index).floorEntry(snap_id).getValue();
	}
}

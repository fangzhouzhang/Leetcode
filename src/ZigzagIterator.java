import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
	private List<Integer> data;
	private int index;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		initData(v1, v2);
	}

	public int next() {
		if (index < data.size()) {
			return data.get(index++);
		}
		return Integer.MIN_VALUE;
	}

	public boolean hasNext() {
		if (index >= data.size()) {
			return false;
		}
		return true;
	}
	private void initData(List<Integer> v1, List<Integer> v2) {
		data = new ArrayList<>();
		if (v1 == null && v2 == null) {
			return;
		} else if (v1 != null && v2 == null) {
			data = v1;
			return;
		} else if (v1 == null && v2 != null) {
			data = v2;
			return;
		}
		int i = 0;
		int j = 0;
		int count = 0;
		while (i < v1.size() && j < v2.size()) {
			if (count % 2 == 0) {
				data.add(v1.get(i++));
			} else {
				data.add(v2.get(j++));
			}
			count++;
		}
		while (i < v1.size()) {
			data.add(v1.get(i++));
		}
		while (j < v2.size()) {
			data.add(v2.get(j++));
		}
	}
}

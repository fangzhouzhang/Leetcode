import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D {
	private Iterator<List<Integer>> iters;
	private Iterator<Integer> iter;
	public Vector2D(int[][] v) {
		if (v == null || v.length == 0) {
			return;
		}
		List<List<Integer>> list = getList(v);
		if (list.size() == 0) {
			return;
		}
		iters = list.iterator();
		iter = iters.next().iterator();
	}

	private List<List<Integer>> getList(int[][] arrays) {
		List<List<Integer>> list = new ArrayList<>();
		for (int[] arr: arrays) {
			List<Integer> tmp = new ArrayList<>();
			for (int num: arr) {
				tmp.add(num);
			}
			if (tmp.size() > 0)
				list.add(tmp);
		}
		return list;
	}

	private void getNext() {
		while (!iter.hasNext() && iters.hasNext()) {
			iter = iters.next().iterator();
		}
	}

	public int next() {
		Integer ret = iter.next();
		getNext();
		return ret;
	}

	public boolean hasNext() {
		return iter != null && iter.hasNext();
	}
}

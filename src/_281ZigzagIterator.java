import java.util.List;

public class _281ZigzagIterator {
	private class ZigzagIterator {
		private List<Integer> v1;
		private List<Integer> v2;
		private int i1;
		private int i2;
		private boolean v1Turn;
		public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
			this.v1 = v1;
			this.v2 = v2;
			i1 = 0;
			i2 = 0;
			v1Turn = true;
		}

		public int next() {
			if (i1 < v1.size() && i2 < v2.size()) {
				if (v1Turn) {
					v1Turn = false;
					return v1.get(i1++);
				} else {
					v1Turn = true;
					return v2.get(i2++);
				}
			} else if (i1 < v1.size()) {
				return v1.get(i1++);
			} else if (i2 < v2.size()) return v2.get(i2++);
			else return -1;
		}

		public boolean hasNext() {
			if (i1 >= v1.size() && i2 >= v2.size()) return false;
			return true;
		}
	}
}

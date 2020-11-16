import java.util.ArrayList;
import java.util.List;

public class _1656DesignanOrderedStream {
	class OrderedStream {
		String[] a;
		int i;
		public OrderedStream(int n) {
			a = new String[n + 1];
			i = 1;
		}

		public List<String> insert(int id, String value) {
			a[id] = value;
			List<String> res = new ArrayList<>();
			if (a[i] == null) return res;
			while (i < a.length && a[i] != null) {
				res.add(a[i++]);
			}
			return res;
		}
	}
}

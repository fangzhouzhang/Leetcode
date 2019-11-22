import java.util.ArrayList;
import java.util.List;

public class _118PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> tmp = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) tmp.add(1);
				else if (i > 0 && j > 0) tmp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
			}
			res.add(tmp);
		}
		return res;
	}
}

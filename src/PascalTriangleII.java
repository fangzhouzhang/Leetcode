import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		res.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i; j >= 1; j--) {
				if (j == i) {
					res.add(1);
				} else {
					res.set(j, res.get(j - 1) + res.get(j));
				}
			}
		}
		return res;
	}
}

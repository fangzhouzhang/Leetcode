import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		int len = 1 << n;
		for (int i = 0; i < len; i++) {
			res.add(i ^ (i >> 1));
		}
		return res;
	}
}

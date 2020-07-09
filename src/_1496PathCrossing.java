import java.util.HashSet;
import java.util.Set;

public class _1496PathCrossing {
	public boolean isPathCrossing(String path) {
		Set<String> set = new HashSet<>();
		set.add(0 + ":" + 0);
		int curX = 0;
		int curY = 0;
		for (char c : path.toCharArray()) {

			if (c == 'N') {
				curX = curX + 0;
				curY = curY + 1;
			} else if (c == 'E') {
				curX = curX + 1;
				curY = curY + 0;
			} else if (c == 'S') {
				curX = curX + 0;
				curY = curY- 1;
			} else {
				curX = curX - 1;
				curY = curY;
			}
			if (!set.add(curX + ":" + curY)) return true;
		}
		return false;
	}
}

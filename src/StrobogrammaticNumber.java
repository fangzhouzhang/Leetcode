import java.util.HashSet;
import java.util.Set;

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		Set<String> set = new HashSet<>();
		set.add("00");
		set.add("11");
		set.add("69");
		set.add("96");
		set.add("88");

		for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
			if (!set.contains(num.charAt(i) + "" +num.charAt(j))) {
				return false;
			}
		}
		return true;
	}
}

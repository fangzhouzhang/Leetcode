import java.util.HashSet;
import java.util.Set;

public class _246StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		if (num == null || num.length() == 0) return false;
		Set<String> set = new HashSet<>();
		set.add("00");
		set.add("11");
		set.add("69");
		set.add("96");
		set.add("88");
		int i = 0, j = num.length() - 1;
		while (i <= j) {
			String test = num.charAt(i) + "" + num.charAt(j);
			if (!set.contains(test)) return false;
			i++;
			j--;
		}
		return true;
	}
}

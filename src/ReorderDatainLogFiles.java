import java.util.Arrays;

public class ReorderDatainLogFiles {
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (l1, l2) -> {
			String[] a1 = l1.split(" ", 2);
			String[] a2 = l2.split(" ", 2);
			boolean isD1 = Character.isDigit(a1[1].charAt(0));
			boolean isD2 = Character.isDigit(a2[1].charAt(0));
			if (!isD1 && !isD2) return a1[1].equals(a2[1]) ? a1[0].compareTo(a2[0]) : a1[1].compareTo(a2[1]);
			if (isD1 && isD2) return 0;
			return isD1 ? 1 : -1;
		});
		return logs;
	}
}

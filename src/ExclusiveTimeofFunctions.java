import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] res = new int[n];
		Stack<String[]> s = new Stack<>();
		int preTime = 0;
		for (String str : logs) {
			String[] cur = str.split(":");
			if (cur[1].equals("start") && s.isEmpty()) {
				s.push(cur);
				preTime = Integer.parseInt(cur[2]);
			} else if (cur[1].equals("start") && !s.isEmpty()) {
				String[] prev = s.peek();
				res[Integer.parseInt(prev[0])] += Integer.parseInt(cur[2]) - preTime;
				s.push(cur);
				preTime = Integer.parseInt(cur[2]);
			} else if (cur[1].equals("end") && !s.isEmpty()) {
				String[] prev = s.pop();
				res[Integer.parseInt(prev[0])] += Integer.parseInt(cur[2]) - preTime + 1;
				preTime = Integer.parseInt(cur[2]) + 1;
			}
		}
		return res;
	}
}

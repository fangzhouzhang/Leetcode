import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path.length() == 0) {
			return "";
		}
		Stack<String> stack = new Stack<>();
		String[] parts = path.split("/");
		Set<String> set = new HashSet<>();
		set.add(".");
		set.add("..");
		set.add("");
		for (String part : parts) {
			if (part.equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!set.contains(part)) {
				stack.push(part);
			}
		}
		String res = "";
		while (!stack.isEmpty()) {
			res = "/" + stack.pop() + res;
		}
		if (res.equals("")) {
			return "/";
		} else {
			return res;
		}
	}
}

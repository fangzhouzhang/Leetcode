import java.util.Stack;

public class ConstructBinaryTreefromString {
	public TreeNode str2tree(String s) {
		Stack<TreeNode> stack = new Stack<>();
		int i = 0;
		boolean neg = false;
		while (i < s.length()) {
			if (s.charAt(i) == ')' && !stack.isEmpty()) {
				stack.pop();
				i++;
			} else if (Character.isDigit(s.charAt(i))) {
				int tmp = 0;
				int j = i;
				while (j < s.length() && Character.isDigit(s.charAt(j))) {
					tmp = tmp * 10 + (s.charAt(j) - '0');
					j++;
				}
				TreeNode cur = neg == false ? new TreeNode(tmp) : new TreeNode(-tmp);
				neg = false;
				if (!stack.isEmpty()) {
					TreeNode pre = stack.peek();
					if (pre.left == null) {
						pre.left = cur;
					} else {
						pre.right = cur;
					}
				}
				stack.push(cur);
				i = j;
			} else if (s.charAt(i) == '(') {
				i++;
			} else if (s.charAt(i) == '-') {
				neg = true;
				i++;
			}
		}
		return stack.isEmpty() ? null : stack.peek();
	}
}

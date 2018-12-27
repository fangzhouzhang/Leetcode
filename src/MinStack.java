import java.util.Stack;

public class MinStack {
    //Time : O(1) both push and pop Space: O(n)
	private Stack<Node> mainStack;
	private Stack<Node> sort;
	// private Stack<Integer> mainStack;
	// private Stack<Integer> sort;
	private int idx;
	/** initialize your data structure here. */
	public MinStack() {
		mainStack = new Stack<>();
		sort = new Stack<>();
		idx = 0;
	}

	public void push(int x) {
		mainStack.push(new Node(x, idx));


		if (!sort.isEmpty()) {
			if (x < sort.peek().getVal()) {
				sort.push(new Node(x, idx));
			}
		} else {// sort is empty
			sort.push(new Node(x, idx));
		}

		idx++;

//         mainStack.push(x);


//         if (!sort.isEmpty()) {
//             if (x < sort.peek()) {
//                 sort.push(x);
//             } else if (x == sort.peek()) {
//                 sort.push(x);
//             }
//         } else {
//             sort.push(x);
//         }

		// idx++;
	}

	public void pop() {
		Node node = mainStack.pop();
		if (node == null) {
			return;
		}
		int target = node.getVal();
		int targetIdx = node.getIdx();

		if (!sort.isEmpty()) {
			if (sort.peek().getVal() == target &&
					sort.peek().getIdx() == targetIdx) {
				sort.pop();
				idx--;
			}
		}



//         int target = mainStack.pop();

//         if (!sort.isEmpty()) {
//             if (sort.peek() == target) {
//                 sort.pop();
//             }
//         }


	}

	public int top() {
		return mainStack.peek().getVal();
		// return mainStack.peek();
	}

	public int getMin() {
		return sort.peek().getVal();
		// return sort.peek();
	}
	private class Node {
		private int val;
		private int idx;
		public Node(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
		public int getVal() {
			return this.val;
		}
		public int getIdx() {
			return this.idx;
		}
	}
}

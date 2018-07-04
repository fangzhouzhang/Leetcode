import java.util.Stack;

public class MinStack {
    //Time : O(1) both push and pop Space: O(n)
    Stack<Integer> s1;
    Stack<Node> s2;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        // do intialization if necessary
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        s1.push(number);
        if (number < min) {
            min = number;
            s2.push(new Node(number, s1.size()));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        /*if (s1.size() == s2.peek().pos) {
            s2.pop();
            min = s2.peek().val;
        }*/
        Node node = s2.peek();
        if (node != null) {
            if (s1.size() == node.pos) {
                s2.pop();
                if (s2.size() != 0) {
                    min = s2.peek().val;
                } else {
                    min = Integer.MAX_VALUE;
                }
            }
        }
        return s1.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min;
    }
}
class Node {
    int val;
    int pos;
    public Node(int val, int pos) {
        this.val = val;
        this.pos = pos;
    }
}
import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        // do intialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        while (stack2.size() != 0) {
            stack1.push(stack2.pop());
        }
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        while (stack1.size() != 0) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        while (stack1.size() != 0) {
            stack2.push(stack1.pop());
        }
        int temp = stack2.pop();
        stack2.add(temp);
        return temp;
    }
}
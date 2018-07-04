import java.util.Stack;

public class StackSorting {
    //Time : O(n^2) Space : O(n)
    public void stackSorting(Stack<Integer> stk) {
        // write your code here
        Stack<Integer> raw = new Stack<Integer>();
        //geta all raw data
        int size = stk.size();
        while (stk.size() != 0) {
            raw.push(stk.pop());
        }
        //System.out.println(" raw size " + raw.size());
        for (int i = 0; i < size; i++) {
            int min = Integer.MAX_VALUE;
            int counter = 0;
            while (!raw.isEmpty()) {
                //System.out.println("******************");
                // min = Math.min(min, raw.peek());
                if (min > raw.peek()) {
                    min = raw.peek();
                    counter = 1;
                } else if (min == raw.peek()){
                    counter++;
                }
                stk.push(raw.pop());
                //System.out.println(" min " + min + " stk push " + stk.peek());
                //System.out.println("******************");
            }
// 			int temp = 0;
            while (!stk.isEmpty()) {
                //System.out.println("====================");
                if (stk.peek() == min) {
                    // 	temp = stk.pop();
                    int temp = stk.pop();
                    //System.out.println(" stk.peek() == min " + min + "   " + temp);
                } else if (stk.peek() > min) {
                    raw.push(stk.pop());
                    //System.out.println(" raw " + raw.peek());
                } else {
                    break;
                }
                //System.out.println("====================");
            }
            for (int k = 0; k < counter; k++) {
                stk.push(min);

            }
        }
        return;
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SlidingWindowMaximum {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The maximum number inside the window at each moving
     * time : o(n) space: o(k)
     */
    public ArrayList<Integer> maxSlidingWindow(int[] arr, int k) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 1) {
            for (int num : arr) {
                res.add(num);
            }
            return res;
        }
        if (arr.length < k) {
            return res;
        }
        ArrayDeque<Element> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            //step 1
            if (deque.isEmpty()) {
                deque.addFirst(new Element(i, arr[i]));
            }
            //step 2
            while (!deque.isEmpty() && i - deque.peek().idx >= k) {
                deque.pollFirst();
            }
            //step 3 and 4
            if (!deque.isEmpty() && deque.peekLast().val <= arr[i]) {
                while (!deque.isEmpty() && deque.peekLast().val <= arr[i]) {
                    deque.pollLast();
                }
                deque.addLast(new Element(i, arr[i]));
            } else if (!deque.isEmpty() && deque.peekLast().val > arr[i]) {
                deque.addLast(new Element(i, arr[i]));
            }
            //step 5
            if (i >= k - 1 && !deque.isEmpty()) {
                res.add(deque.peekFirst().val);
            }
        }
        return res;
    }
    class Element {
        int idx;
        int val;
        public Element(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}


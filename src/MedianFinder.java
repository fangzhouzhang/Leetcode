import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	private PriorityQueue<Integer> lo;
	private PriorityQueue<Integer> hi;
	/** initialize your data structure here. */
	public MedianFinder() {
		hi = new PriorityQueue<Integer>();
		lo = new PriorityQueue<Integer>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});
	}

	public void addNum(int num) {
		lo.add(num);
		hi.add(lo.poll());
		if (lo.size() < hi.size()) {
			lo.add(hi.poll());
		}
	}
	public double findMedian() {
		if (lo.size() == hi.size()) {
			return (lo.peek() + hi.peek()) * 1.0 / 2;
		} else {
			System.out.println(lo.size());
			return lo.peek() * 1.0;
		}
	}
}



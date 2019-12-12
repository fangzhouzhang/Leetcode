import java.util.Comparator;
import java.util.PriorityQueue;

public class _295FindMedianfromDataStream {
	class MedianFinder {
		private PriorityQueue<Integer> firstHalf;
		private PriorityQueue<Integer> secondHalf;
		/** initialize your data structure here. */
		public MedianFinder() {
			firstHalf = new PriorityQueue<Integer>(new MyComparator());
			secondHalf = new PriorityQueue<Integer>();
		}

		public void addNum(int num) {
			firstHalf.add(num);
			secondHalf.add(firstHalf.poll());
			if (firstHalf.size() < secondHalf.size()) firstHalf.add(secondHalf.poll());
		}

		public double findMedian() {
			int mod = (firstHalf.size() + secondHalf.size()) % 2;
			if (mod == 0) return (firstHalf.peek() + secondHalf.peek()) * 1.0 / 2;
			else return firstHalf.peek();
		}

		private class MyComparator implements Comparator<Integer> {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		}
	}
}

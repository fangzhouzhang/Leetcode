import java.util.Arrays;

public class MyHeap {
	private static int[] data;
	private  static int count;
	private  static int capacity;
	public MyHeap(int capacity) {
		this.capacity = capacity;
		count = 1;
		data = new int[capacity];

	}
	public  static void push(int x) {
		if (count >= capacity) {
			data = Arrays.copyOf(data, data.length * 2);
		}
		data[count] = x;
		shiftUp(count);
		count++;
	}

	private  static void shiftUp(int count) {
		while (count / 2 >=  1 && data[count / 2] <= data[count]) {
			swap(data, count / 2, count);
			count /= 2;
		}
	}
	public  static int pop() {
		int res = data[1];
		shiftDown();
		count--;

		return res;
	}

	private  static void shiftDown() {
		swap(data, 1, count);
		int cur = 1;
		while (2 * cur < count) {
			int j = 2 * cur;
			if (j + 1 < count && data[j] < data[j + 1]) {
				j = j + 1;
			}
			if (data[j] < data[cur]) {
				break;
			}
			swap(data, cur, j);
			cur = j;
		}
	}

	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}


	public static void main(String[] args) {
		MyHeap heap = new MyHeap(1);
		heap.push(1);
		heap.push(2);
		heap.push(3);
		heap.push(4);
		heap.push(5);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "  ");
		}
	}
}


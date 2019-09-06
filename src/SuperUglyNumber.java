import java.util.PriorityQueue;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		int[] ugly = new int[n];
		ugly[0] = 1;
		int i = 1;
		for (int p : primes) {
			pq.add(new int[]{p, p, 0});
		}
		while (i < n) {
			int[] arr = pq.poll();
			int num = arr[0];
			int prime = arr[1];
			int idx = arr[2];
			if (num != ugly[i - 1]) {
				ugly[i] = num;
				i++;
			}
			pq.add(new int[]{ugly[idx + 1] * prime, prime, idx + 1});
		}
		return ugly[n - 1];
	}
}

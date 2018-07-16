public class MaxProductOfCuttingRope {
    //time: o(n^2) space: o(n)
    public int maxProduct(int length) {
        // Write your solution here
        int[] m = new int[length + 1];
        m[1] = 1;
        m[2] = 1;
        int max = 0;
        for (int i = 3; i < length + 1; i++) {
            max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(m[j], j) * (i - j));
            }
            m[i] = max;
        }
        return m[length];

    }
}

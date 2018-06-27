public class NumArray {
    private int[] nums;
    private int[] prefix;
    public NumArray(int[] nums) {
        this.nums = nums;
        prefix = new int[nums.length + 1];
        getSum(prefix);
    }

    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j < prefix.length; j += lowbit(j)) {
            prefix[j] += delta;
        }
    }

    public int sumRange(int i, int j) {
        int sum1 = 0, sum2 = 0;
        for (int k = j + 1; k > 0; k -= lowbit(k)) {
            int temp = k & k - 1;
            if (temp == 0) {
                break;
            }
            sum1 += prefix[k];
        }
        for (int k = i + 1; k > 0; k -= lowbit(k)) {
            int temp = k & k - 1;
            if (temp == 0) {
                break;
            }
            sum2 += prefix[k];
        }
        System.out.println("sum1 " + sum1 + "sum2 " + sum2);
        return sum1 - sum2;
    }
    public void getSum(int[] prefix) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < prefix.length; j += lowbit(j)) {
                prefix[j] += nums[i];
            }
        }
    }
    public int lowbit(int i) {
        int res = i & (-i);
        return res;
    }

    public void print() {
        for (int i = 0; i < prefix.length; i++) {
            System.out.println("prefix[" + i + "] " + prefix[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[" + i + "] " + nums[i]);
        }
    }
}

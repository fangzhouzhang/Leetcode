import java.util.List;

public class MajorityNumberIII {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     * time: o(n * k) space: o(k)
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        Element[] arr = new Element[k];
        for (int i = 0; i < k; i++) {
            arr[i] = new Element(Integer.MIN_VALUE, 0);
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            for (int j = 0; j < arr.length; j++) {
                if (num == arr[j].val) {
                    arr[j].cnt++;
                    break;
                } else if (arr[j].cnt == 0) {
                    arr[j].val = num;
                    arr[j].cnt = 1;
                    break;
                } else if (j == arr.length - 1 && arr[j].cnt > 0) {
                    for (int m = 0; m < arr.length; m++) {
                        arr[m].cnt--;
                    }
                }
            }

        }
        for (int j = 0; j < arr.length; j++) {
            arr[j].cnt = 0;
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            for (int j = 0; j < arr.length; j++) {
                if (num == arr[j].val) {
                    arr[j].cnt++;
                    break;
                }
            }
        }
        int max = 0;
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].cnt > max) {
                max = arr[j].cnt;
                res = arr[j].val;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j].val + "   " + arr[j].cnt);
        }
        return res;
    }
    class Element {
        int val;
        int cnt;
        public Element(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}


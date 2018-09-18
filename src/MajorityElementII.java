import java.util.List;

public class MajorityElementII {
    /**
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     * time: o(n) space: o(1)
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        Element[] arr = new Element[2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Element(Integer.MIN_VALUE, 0);
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == arr[0].val) {
                arr[0].cnt++;
            } else if (nums.get(i) == arr[1].val) {
                arr[1].cnt++;
            } else if (arr[0].cnt == 0) {
                arr[0].val = nums.get(i);
                arr[0].cnt = 1;
            } else if (arr[1].cnt == 0) {
                arr[1].val = nums.get(i);
                arr[1].cnt = 1;
            } else {
                arr[0].cnt--;
                arr[1].cnt--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i].cnt = 0;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == arr[0].val) {
                arr[0].cnt++;
            } else if (nums.get(i) == arr[1].val) {
                arr[1].cnt++;
            }
        }
        if (arr[0].cnt > arr[1].cnt) {
            return arr[0].val;
        } else {
            return arr[1].val;
        }
    }
    class Element {
        int val;
        int cnt;
        public Element(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
    public int majorityNumber_II(List<Integer> nums) {
        // write your code here
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (Integer num: nums) {
            if (count1 == 0) {
                candidate1 = num;
            } else if (count2 == 0) {
                candidate2 = num;
            }

            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (Integer num: nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > count2) {
            return candidate1;
        } else {
            return candidate2;
        }
    }

}


public class ReverseWordsinaString {
    /*
     * @param s: A string
     * @return: A string
     * time: o(n) space:o(n)
     */
    public String reverseWords(String s) {
        // write your code here
        if (s == "") {
            return "";
        }
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        reverseSingleWord(arr, 0, arr.length - 1);
        s = String.valueOf(arr);
        return s.trim();
    }
    public void reverseSingleWord(char[] arr, int l, int r) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] != ' ') {
                while (j < arr.length && arr[j] != ' ') {
                    j++;
                }
                reverse(arr, i, j - 1);
                i = j;
            } else {
                i++;j++;
            }
        }
    }
    public void reverse(char[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(arr, l, r);
        reverse(arr, ++l, --r);
    }
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

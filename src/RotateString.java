public class RotateString {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     * time: o(n) space:o(1)
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (offset == 0) {
            return;
        }
        if (str.length == 0) {
            return;
        }
        if (offset >= str.length - 1) {
            offset = offset % str.length;
        }
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length - 1);
    }
    public void reverse(char[] str, int l, int r) {
        for (; l < r; l++, r--) {
            swap(str, l, r);
        }
    }
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

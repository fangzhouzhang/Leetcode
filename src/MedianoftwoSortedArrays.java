public class MedianoftwoSortedArrays {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     * time : o(log min(m, n)) space: o(1)
     */
    public  double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null && B == null) {
            return -1;
        }
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }
        int len = A.length + B.length;
        if (A.length == 0) {
            return len % 2 == 0 ? (B[len / 2 - 1] + B[len / 2]) / 2.0 : B[len / 2] / 1.0;
        }
        int start = 0;
        int end = A.length - 1;
        int idx = 0;
        int rem = 0;
        while (true) {
            idx = start + (end - start) / 2;
            System.out.println("idx  " + idx);
            rem = len / 2 - idx;
            int idxL = idx < 1 || idx > A.length ? Integer.MIN_VALUE : A[idx - 1];
            int idxR = idx < 0 || idx > A.length - 1 ? Integer.MAX_VALUE : A[idx];
            int remL = rem < 1 || rem > B.length ? Integer.MIN_VALUE : B[rem - 1];
            int remR = rem < 0 || rem > B.length - 1 ? Integer.MAX_VALUE : B[rem];
            if (idxL > remR) {
                end = idx - 1;
                System.out.println(1);
            } else if (remL > idxR) {
                start = idx + 1;
                System.out.println(2);
            } else if (idxL <= remR && remL <= idxR) {
                System.out.println(3);
                if (len % 2 == 0) {
                    return (Math.max(idxL, remL) + Math.min(idxR, remR)) * 1.0 / 2;
                } else {
                    return Math.min(idxR, remR) / 1.0;
                }
            }
        }
        //return 0.0;
    }
}

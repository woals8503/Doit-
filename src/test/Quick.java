package test;

public class Quick {

    public static void merge_sort(int[] a) {
        quick_sort(a, 0, a.length-1);
    }

    private static void quick_sort(int[] a, int lo, int hi) {

        int pivot = partition(a, lo, hi);
        quick_sort(a, lo, pivot);
        quick_sort(a, pivot+1, hi);
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[(left + right) / 2];
        int lo = left - 1;
        int hi = right + 1;

        do {
            lo++;
        } while(a[lo] > pivot);

        do {
            hi--;
        } while(a[hi] < pivot);

        if(lo >= hi) return hi;

        swap(a, lo, hi);

        return 0;
    }

    private static void swap(int[] a, int lo, int hi) {
        int tmp = a[lo];
        a[lo] = a[hi];
        a[hi] = tmp;
    }
}

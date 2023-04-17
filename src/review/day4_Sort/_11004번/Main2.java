package review.day4_Sort._11004번;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        pivot_sort(arr, 0, arr.length-1);
        System.out.println(arr[K-1]);
    }

    private static void pivot_sort(int[] arr, int lo, int hi) {
        if(lo >= hi) return;

        int pivot = partition(arr, lo, hi);
        pivot_sort(arr, lo, pivot);
        pivot_sort(arr, pivot+1, hi);
    }

    private static int partition(int[] arr, int left, int right) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = arr[(left + right) / 2];

        while(true) {
            do {
                lo++;
            } while(arr[lo] < pivot);

            do {
                hi--;
            } while(arr[hi] > pivot);

            if(lo >= hi) return hi;

            swap(arr, lo, hi);
        }
    }

    private static void swap(int[] arr, int lo, int hi) {
        int tmp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = tmp;
    }
}

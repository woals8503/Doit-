package basic.day5._11004번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        pivot_sort(arr, 0, arr.length-1);
        System.out.println(arr[K-1]);
    }

    private static void pivot_sort(int[] arr, int lo, int hi) {
        if(lo >= hi) return;    // lo가 hi보다 같거나 높다면 정렬할 것이 없으므로 바로 리턴

        int pivot= partition(arr, lo, hi);

        pivot_sort(arr, lo, pivot); //이 부분에서 삽질함 why? => 재귀호출을 한 것이 아닌 단순 메소드 호출만 했다.

        pivot_sort(arr,pivot+1, hi);
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
            } while(arr[hi] > pivot && lo <= hi);

            if(lo >= hi) return hi;

            swap(arr, lo, hi);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

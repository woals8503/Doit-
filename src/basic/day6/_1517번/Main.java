package basic.day6._1517번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long[] sorted;
    private static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        sorted = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        merge_sort(arr, 0, arr.length-1);
        System.out.println(count);
    }

    private static void merge_sort(long[] arr, int left, int right) {

        if(left == right) return;

        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(long[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while(l <= mid && r <= right) {
            //왼쪽 값이 오른쪽 값보다 작을 경우
            if(arr[l] <= arr[r]) {  
                sorted[idx] = arr[l];
                l++;
                idx++;
            }
            //오른쪽 값이 왼쪽 값보다 작을 경우
            else {
                sorted[idx] = arr[r];
                count += r - idx;
                idx++;
                r++;
            }
        }
        
        if(l > mid) {
            while(r <= right) {
                sorted[idx] = arr[r];
                r++;
                idx++;
            }
        }
        else {
            while(l <= mid) {
                sorted[idx] = arr[l];
                l++;
                idx++;
            }
        }

        for(int i=left; i<=right; i++) {
            arr[i] = sorted[i];
        }
    }
}

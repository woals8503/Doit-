package review.day4_Sort._2751번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        sorted = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        merge_sort(arr, 0, arr.length-1);
    }

    private static void merge_sort(int[] arr, int left, int right) {
        if(left == right) return;

        int mid = (left + right) / 2;

        merge_sort(arr, left, mid);
        merge_sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while(l <= mid && r <= right) {
            if(arr[l] < arr[r]) {
                sorted[idx] = arr[l];
                l++;
                idx++;
            }
            else {
                sorted[idx] = arr[r];
                r++;
                idx++;
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

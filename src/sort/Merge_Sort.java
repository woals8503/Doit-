package sort;

public class Merge_Sort {
    private static int[] sorted;

    public static void merge_sort(int[] a) {
        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    private static void merge_sort(int[] a, int left, int right) {

        // 더이상 쪼갤 수 없을 때 return
        if(left == right) return;

        int mid = (left + right) / 2;   // 반으로 나눔

        merge_sort(a, left, mid);           // left ~ mid
        merge_sort(a, mid+1, right);    // mid+1 ~ right

        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;       // 왼쪽 부분 리스트 시작점
        int r = mid + 1;    // 오른쪽 부분 리스트 시작점
        int idx = left;     // 채워넣을 배열의 인덱스

        while(l <= mid && r <= right) {

            if(a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }

            else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        //왼쪽 부분리스트가 먼저 새 배열에 모두 채워졌을 때 ( l > mid )
        // 오른쪽 부분리스트가 남아있을 경우 오른쪽 부분리스트의 나머지 원소를 새 배열에 채운다.
        if(l > mid) {
            while(r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        else {
            while(l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        for(int i=left; i<=right; i++) {
            a[i] = sorted[i];
        }
    }
}

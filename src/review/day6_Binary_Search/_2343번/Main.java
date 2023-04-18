package review.day6_Binary_Search._2343번;

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
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int result = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= M) {
                rt = mid - 1;
                result = mid;
            }
            else lt = mid + 1;
        }
        System.out.println(result);
    }

    private static int count(int[] arr, int mid) {
        int count = 1;
        int sum = 0;

        for (int x : arr) {
            if(sum + x > mid) {
                count++;
                sum = x;
            }
            else sum += x;
        }
        return count;
    }
}

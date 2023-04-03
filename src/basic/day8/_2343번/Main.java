package basic.day8._2343번;

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
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= M) {
                answer = mid;
                rt = mid - 1;
            }
            else lt = mid + 1;
        }
        System.out.println(answer);
    }

    public static int count(int[] arr, int mid) {
        int count = 1;  // 1로 지정한 이유 : 마지막 연산 때는 if절을 수행하지 않고 끝나기 때문이다.
        int sum = 0;
        for(int x : arr) {
            if(x + sum > mid) {
                count++;
                sum = x;
            }
        }
        return count;
    }
}

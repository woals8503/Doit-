package basic.day9._11047번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int sum = 0;
        int count = 0;

        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] <= K) {
                count += (K / arr[i]);
                K %= arr[i];
            }
        }
        System.out.println(count);
    }
}

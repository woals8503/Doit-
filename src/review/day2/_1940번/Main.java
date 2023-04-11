package review.day2._1940번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length-1;
        int count = 0;

        while(lt < rt) {
            if(arr[lt] + arr[rt] == M) {
                count++;
                rt--;
                lt++;
            }
            else if(arr[lt] + arr[rt] < M) lt++;
            else rt--;
        }
        System.out.println(count);
    }
}

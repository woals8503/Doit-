package basic.day2.__1940번;

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
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int lt = 0;
        int rt = N-1;
        int count = 0;

        while(lt < rt) {
            if(arr[lt] + arr[rt] == M) {
                rt--;
                lt++;
                count++;
            }
            else if(arr[lt] + arr[rt] > M)  rt--;
            else lt++;
        }
        System.out.println(count);
    }
}

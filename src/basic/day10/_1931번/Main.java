package basic.day10._1931번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0] - o2[0];

            else return o1[1] - o2[1];
        });

        int count = 0;
        int end = -1;

        for(int i=0; i<N; i++) {
            if(arr[i][0] >= end) {
                count++;
                end = arr[i][1];
            }
        }
        System.out.println(count);
    }

}

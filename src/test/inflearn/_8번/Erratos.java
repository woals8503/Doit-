package test.inflearn._8번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Erratos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for(int j=0; j<2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=1; k<=N; k++)
                    arr[j][k] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for(int l=2; l<=N; l++) {
                dp[0][l] = Math.max(dp[1][l-1], dp[1][l-2]) + arr[0][l];
                dp[1][l] = Math.max(dp[0][l-1], dp[0][l-2]) + arr[1][l];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }

}

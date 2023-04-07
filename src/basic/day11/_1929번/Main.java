package basic.day11._1929번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[N+1];
        check[0] = check[1] = true;

        for(int i=2; i<=Math.sqrt(N); i++) {
            if(!check[i]) {
                for(int j=i*i; j<=N; j+=i)
                    check[j] = true;
            }
        }

        for(int i=M; i<=N; i++)
            if(!check[i]) sb.append(i).append("\n");

        System.out.println(sb);
    }
}
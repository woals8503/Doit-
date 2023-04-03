package basic.day8._1300번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1, end = K;
        long answer = 0;

        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for(int i=1; i<=N; i++)
                cnt += Math.min(mid / i, N);

            if(cnt < K)
                start = mid + 1;
            else {
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

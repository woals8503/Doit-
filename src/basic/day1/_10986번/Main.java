package basic.day1._10986번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sum = new long[N+1];
        long[] cnt = new long[M];
        long result = 0;

        //누적합 저장
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        
        //M으로 나누어서 같은 값 판별
        for(int i=1; i<=N; i++) {
            int tmp = (int)(sum[i] % M);

            if(tmp == 0) result++;

            cnt[tmp]++;
        }

        for(int i=0; i<M; i++) {
            //2개는 무조건 뽑아야 해서 1개 이상
            if(cnt[i] > 1) {
                result += (cnt[i] * (cnt[i]-1)/ 2) ;
            }
        }

        System.out.println(result);
    }
}
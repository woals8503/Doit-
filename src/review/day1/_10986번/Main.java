package review.day1._10986번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 최대 100만
        int M = Integer.parseInt(st.nextToken());   // 최대 1000
        long[] arr = new long[N+1];
        long[] cnt = new long[M];
        st = new StringTokenizer(br.readLine());    // 값 10억
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];   //합을 구할 때 10억 + @ 라서 arr배열은 long 사용
        }

        long result = 0;
        for(int i=1; i<=N; i++) {
            int tmp = (int) (arr[i] % M); // 2. 그래서 int로 형 변환
            if(tmp == 0) result++;
            cnt[tmp]++; // 1. 배열 속 tmp는 long은 올 수 없음
        }

        for(int i=0; i<M; i++) {
            if(cnt[i] > 1) {
                result += (cnt[i] * (cnt[i]-1) / 2);
            }
        }
        System.out.println(result);
    }
}

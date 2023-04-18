package review.day6_Binary_Search._1300번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long K = Long.parseLong(br.readLine());

        long lt = 1;
        long rt = K;    // K가 결국 배열 크기의 끝이 될 수도 있고 아닐 수도 있다. K 이상의 값을 탐색할 필요는 없다.
        long result = 0;

        while(lt <= rt) {
            long x = (lt + rt) /2;    // mid는 B[K] = x 에서 x의 값이다. 이 x의 값을 조정하면서 이분 탐색을 진행한다.
            long count = 0;

            // 1부터 N까지 x값보다 아래에 있는 숫자가 몇개인지 탐색한다.
            // 주의할 점은 N은 3인데 x값인 9를 탐색해야 할 경우 9/1을 하면 1단에서는 9보다 작은 수가 9개가 나온다.
            // 2단에서는 9/2 로서 4의 값이 나오는데 이럴 경우 N의 배열의 크기는 3인데 3을 초과해버린다.
            // ex -> [ 2, 4, 6 ] 인데 4의 값은 배열의 갯수보다 초과되기 때문에 초과될경우 배열의 크기로 고정시켜줘야한다.
            for(int i=1; i<=N; i++)
                count += Math.min(x / i, N);

            if(count < K)
                lt = x + 1;
            else {
                result = x;
                rt = x - 1;
            }
        }

        System.out.println(result);
    }
}

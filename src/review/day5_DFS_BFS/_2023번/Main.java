package review.day5_DFS_BFS._2023번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int start, int depth) {
        //자리수가 4자리일 경우 밑의 코드 수행 시 5자리가 되서 따로 처리
        if(depth == N) {
            if(isPrime(start))
                System.out.println(start);
        }

        //1~9까지 소수인지 아닌지 탐색
        for(int i=1; i<10; i++) {
            
            //2로 나눠질 경우 무시하고 계속
            if(i % 2 == 0) continue;

            if(isPrime(start * 10 + i)) {
                //소수일 경우
                DFS(start * 10 + i, depth + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        
        //num / 2는 해당 숫자의 절반 이하 값만 해당 숫자로 나눌 수 있기 때문
        for(int i=2; i<num/2; i++) {
            if(num % i == 0) return false;
        }

        //값이 안나눠질 경우 소수이므로 true
        return true;
    }
}

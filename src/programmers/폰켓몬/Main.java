package programmers.폰켓몬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(PocketmonManager manager, int N) {
        int result = manager.divide(N);
        int answer = manager.selectMaxPocketmon(result);
        return answer;
    }


    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        //포켓몬 N마리
        int N = Integer.parseInt(br.readLine());

        PocketmonManager manager = new PocketmonManager();

        for(int i=0; i<N; i++) {
            String name = br.readLine();
            int number = Integer.parseInt(br.readLine());   // 포켓몬 번호
            manager.addPocketmon(new Pocketmon(name, number));
        }

        int solution = T.solution(manager, N);
        System.out.println(solution);
    }

}

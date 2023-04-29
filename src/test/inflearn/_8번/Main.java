package test.inflearn._8번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sequence = new int[7];
        for(int i=0; i<sequence.length; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        int[] answer = new int[2];

        int lt = 0;
        int rt = 1;
        int sum = sequence[lt];
        int min = Integer.MAX_VALUE;

        while(rt <= sequence.length-1) {
            if(sum + sequence[rt] == k) {
                sum += sequence[rt];
                if(min > rt - lt) {
                    min = rt - lt;
                    answer[0] = lt;
                    answer[1] = rt;
                }
                rt++;
            }

            else if(sum + sequence[rt] < k){
                sum += sequence[rt];
                rt++;
            }

            else {
                sum -= sequence[lt];
                lt++;
            }
        }

        System.out.println(Arrays.toString(answer));
        //min이 결국 인덱스
    }
}

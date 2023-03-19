package basic.day3._1874번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        boolean result = true;
        for(int i=0; i<N; i++) {
            int now = arr[i];

            //현재 값이 num ( 오름차순 기준 값 ) 보다 클 경우 오름차순 만족
            if(now >= num) {
                while(now >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                int pop = stack.pop();  //pop이 3이고 now가 2라면?
                //3을 뽑아야 오름차순이 만족되는데 배열에서 뽑은 값이 2라면 오름차순 불가
                if(pop < now) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                sb.append("-\n");
            }
        }
        if(result)
        System.out.println(sb.toString());
    }
}

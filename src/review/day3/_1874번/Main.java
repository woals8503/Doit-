package review.day3._1874번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int point = 1;
        boolean flag = true;
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input >= point) {
                while(input >= point) {
                    stack.push(point++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                int n = stack.pop();
                
                //스택에서 꺼낸값이 요구하는 input값보다 클경우
                if(n > input) {
                    System.out.println("NO");
                    flag = false;
                    break;
                }

                sb.append("-\n");
            }
        }
        if(flag)
            System.out.println(sb.toString());
    }
}

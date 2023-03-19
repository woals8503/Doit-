package basic.day3._17298번;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; //수열 배열
        int[] result = new int[N];  //결과 배열

        //수열배열에 값 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //스택 선언
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  //스택 초기 index 저장

        for(int i=1; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        //빈 배열에 -1 저장
        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
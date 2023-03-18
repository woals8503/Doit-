package basic.day2._11003번;

import org.w3c.dom.Node;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            //i+L+1
            int now = Integer.parseInt(st.nextToken());

            // now보다 큰 값 삭제
            while(!deque.isEmpty() && deque.getLast().value > now)
                deque.removeLast();

            // deque에 index와 now값 추가
            deque.addLast(new Node(i, now));
            
            // now = i+L+1 인데 i+L이 deque에 존재할 경우 삭제
            if(deque.getFirst().index <= i-L)
                deque.removeFirst();
            
            //system print는 시간 초과
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
    static class Node {
        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

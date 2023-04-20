package review.day7_Greedy._1715번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int a = 0;
        int b = 0;
        int sum = 0;

        while(pq.size() != 1) {
            a = pq.poll();
            b = pq.poll();
            sum += a + b;   //합계 구하기
            pq.add(a + b);
        }

        System.out.println(sum);
    }
}

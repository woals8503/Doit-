package basic.day9._1744번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> mq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        int one = 0;
        int zero = 0;
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num < 0) mq.add(num);
            else if(num == 0) zero++;
            else if(num == 1) one++;
            else pq.add(num);
        }

        int sum = 0;
        while(mq.size() > 1) {
            int x = mq.poll();
            int y = mq.poll();
            sum += (x * y);
        }
        //zero가 0이면 0이 없다는 소리이며 그대로 음수를 sum에 누적한다.
        if(!mq.isEmpty() && zero == 0)
            sum += mq.poll();

        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            sum += x * y;
        }
        if(!pq.isEmpty())
            sum += pq.poll();

        sum += one;
        System.out.println(sum);
    }
}
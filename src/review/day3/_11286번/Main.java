package review.day3._11286번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            //절대값이 같을 경우
            if(first_abs == second_abs)
                return o1 > o2 ? 1 : -1;
            //절대값이 다를 경우 내 자신 - 비교값  =>  음수일 경우 내자신이 더 작음
            //                                =>  양수일 경우 내 자신이 더 큼
            else
                return first_abs - second_abs;
        });

        for(int i=0; i<N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(queue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(queue.poll());
            }
            else
                queue.add(request);

        }
    }
}

package basic.day3._11286번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                //절대값으로 변환
//                int first_abs = Math.abs(o1);   //내가 사용한 값
//                int second_abs = Math.abs(o2);  //비교 대상
//                if (first_abs == second_abs)    //동일한 값이면 순수 값 비교
//                    return o1 > o2? 1 : -1;    // 1(true) 서로 위치 바꿈 -> 내림차순   -1 (false) 그대로 냅둠 -> 오름차순(default)
//                else
//                    return first_abs - second_abs;
//            }
//        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if(first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            else
                return first_abs - second_abs;
        });

        for(int i=0; i<N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(queue.isEmpty()) {
                    System.out.println("0");
                }
                else
                    System.out.println(queue.poll());
            }
            else
                queue.add(request);
            System.out.println(queue);
        }
    }
}

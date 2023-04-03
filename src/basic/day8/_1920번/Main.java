package basic.day8._1920번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int lt = 0;
            int rt = list.size()-1;
            boolean flag = false;
            while(lt <= rt) {
                int mid = (lt + rt) / 2;
                if(list.get(mid) == target) {
                    flag = true;
                    break;
                }
                else if (list.get(mid) > target) rt = mid - 1;
                else lt = mid + 1;
            }
            if(!flag) System.out.println("0");
            else System.out.println("1");
        }
    }
}

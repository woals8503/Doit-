package basic.day2._2018번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int lt = 1, rt = 1;
        int sum = 1;
        int count = 1;

        while(rt != N) {
            if(sum == N) {
                count++;
                rt++;
                sum += rt;
            }
            else if(sum > N) {
                sum -= lt;
                lt++;
            }
            else {
                rt++;
                sum += rt;
            }
        }
        System.out.println(count);
    }
}

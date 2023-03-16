package basic.day1._1546번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];
        double max = 0;
        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            //최댓값 설정
            if(arr[i] > max) max = arr[i];
        }
        
        for(int i=0; i<N; i++) {
            sum += (arr[i]/max)*100;
        }
        System.out.println(sum / N);
    }
}

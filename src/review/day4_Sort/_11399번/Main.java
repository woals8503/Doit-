package review.day4_Sort._11399번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++) {
            int tmp = arr[i];
            int j = i-1;

            while(j>=0 && tmp < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = tmp;
        }

        int sum = 0;
        int result = 0;
        for(int i=0; i<N; i++) {
            sum += arr[i];
            result += sum;
        }
        System.out.println(result);
    }
}

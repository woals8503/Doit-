package review.day6_Binary_Search._1920번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int lt = 0;
            int rt = arr.length-1;

            while(lt <= rt) {
                int mid = (lt + rt) / 2;

                if(arr[mid] == num) {
                    System.out.println("1");
                    flag = true;
                    break;
                }

                else if(arr[mid] < num)
                    lt = mid + 1;
                else rt = mid - 1;
            }

            if(!flag) System.out.println("0");
        }
    }
}

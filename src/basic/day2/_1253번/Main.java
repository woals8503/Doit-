package basic.day2._1253번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;

        for(int i=0; i<N; i++) {
            long K = arr[i];
            int lt = 0;
            int rt = N-1;
            while(lt < rt) {
                if(arr[lt] + arr[rt] == K) {
                    if(lt != i && rt != i) {
                        count++;
                        break;
                    }
                    else if(rt == i) rt--;
                    else if(lt == i) lt ++;
                }
                //반례 0 0 2 2 2
                else if(arr[lt] + arr[rt] > K) rt--;
                else lt++;
            }
        }
        System.out.println(count);
    }
}

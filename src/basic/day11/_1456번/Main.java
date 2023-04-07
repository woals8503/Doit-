package basic.day11._1456번;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        long[] A = new long[10000001];
        for(int i=2; i<A.length; i++)
            A[i] = i;

        //에라토스테네스 소수 판별
        for(int i=2; i<=Math.sqrt(A.length); i++) {
            if(A[i] == 0) continue;

            for(int j = i * i; j<A.length; j+=i) {
                A[j] = 0;
            }
        }

        int count = 0;

        for(int i=2; i<10000001; i++) {
            if(A[i] != 0) {
                long tmp = A[i];

                while((double)A[i] <= (double)max / (double)tmp) {
                    if((double)A[i] >= (double)min / (double)tmp)
                        count++;

                    tmp *= A[i];
                }
            }
        }
        System.out.println(count);
    }
}

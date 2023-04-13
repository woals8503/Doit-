package review.day4._1427번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long[] arr = new long[str.length()];

        for(int i=0; i<str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for(int i=0; i<str.length()-1; i++) {
            int max = i;
            for(int j=i+1; j<str.length(); j++) {
                if(arr[max] < arr[j]) {
                    max = j;
                }
            }

            swap(arr, max, i);
        }

        for(int i=0; i<str.length(); i++) {
            System.out.print(arr[i]);
        }
    }

    private static void swap(long[] arr, int max, int i) {
        long tmp = arr[max];
        arr[max] = arr[i];
        arr[i] = tmp;
    }
}

package basic.day11._1747번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10000001];

        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        for(int i=2; i < Math.sqrt(arr.length); i++) {
           if(arr[i] == 0) continue;

            for(int j=i*i; j<arr.length; j+=i) {
                arr[j] = 0;
            }
        }

        int i = N;
        while(true) {
            if(arr[i] != 0) {
                int result = arr[i];
                if(palindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean palindrome(int result) {
        char[] tmp = String.valueOf(result).toCharArray();
        int lt = 0;
        int rt = tmp.length-1;

        while(lt < rt) {
            if(tmp[lt] != tmp[rt])
                return false;
            lt++;
            rt--;
        }
        return true;
    }
}

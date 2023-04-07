package basic.day10._1541번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split("-");
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            int tmp = strSplitAndSum(arr[i]);
            if(i==0) sum += tmp;
            else sum -= tmp;
        }
        System.out.println(sum);
    }

    private static int strSplitAndSum(String x) {
        String[] arr = x.split("[+]");
        int sum = 0;
        for(String num : arr) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}

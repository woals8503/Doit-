package basic.day1._11720번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int sum = 0;
        for (char x : number.toCharArray()) {
            sum += x - '0';
        }
        System.out.println(sum);
    }
}

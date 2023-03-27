package basic.day5._11399번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Insert[] arr = new Insert[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = new Insert(i, Integer.parseInt(st.nextToken()));

        for(int i=1; i<N; i++) {
            int target = arr[i].value;
            int j = i-1;

            while(j >= 0 && arr[j].value > target) {
                arr[j+1].value = arr[j].value;
                j--;
            }
            arr[j+1].value = target;
        }

        int sum = 0;
        int result = 0;
        for (Insert insert : arr) {
            sum += insert.value;
            result += sum;
        }
        System.out.println(result);
    }
}

class Insert {
    int index;
    int value;

    public Insert(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

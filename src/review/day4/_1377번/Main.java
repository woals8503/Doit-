package review.day4._1377번;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BubbleSort[] arr = new BubbleSort[N];
        for(int i=0; i<N; i++)
            arr[i] = new BubbleSort(i, Integer.parseInt(br.readLine()));

        Arrays.sort(arr);

        int max = 0;
        for(int i=0; i<N; i++) {
            if(max < arr[i].index - i) {
                max = arr[i].index - i;
            }
        }
        System.out.println(max + 1);

    }

    static class BubbleSort implements Comparable<BubbleSort> {
        int index;
        int value;

        public BubbleSort(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(BubbleSort o) {
            return this.value - o.value;
        }
    }
}

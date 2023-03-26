package basic.day4._1377번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Bubble[] arr = new Bubble[N];
        for(int i=0; i<N; i++)
            arr[i] = new Bubble(i, Integer.parseInt(br.readLine()));

        Arrays.sort(arr); //Comparable에 의한 오름차순 정렬

        int max = 0;

        for(int i=0; i<N; i++) {
            if(max < arr[i].index - i) {
                max = arr[i].index - i;
            }
        }
        System.out.println(max + 1);
    }
}

class Bubble implements Comparable<Bubble> {
    int index;
    int value;

    public Bubble (int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Bubble o) {
        return this.value - o.value;
    }
}


package basic.day5._11399번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Person> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(new Person(i, x));
        }
        Collections.sort(list);

        int sum = 0;
        int result = 0;

        for (Person person : list) {
            sum += person.value;
            result += sum;
        }

        System.out.println(result);

    }
}

class Person implements Comparable<Person> {
    int index;
    int value;

    public Person(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Person o) {
        return this.value - o.value;
    }

}

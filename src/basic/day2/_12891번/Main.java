package basic.day2._12891번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] myPwd;
    static int[] pwd;
    static int checkCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        pwd = new int[4];
        myPwd = new int[4];
        int result = 0;

        char[] arr = new char[S];
        arr = br.readLine().toCharArray();  //배열에 문자 저장

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            pwd[i] = Integer.parseInt(st.nextToken());
            if(pwd[i] == 0) checkCount++;
        }

        for(int i=0; i<P; i++) {
            add(arr[i]);
        }

        if(checkCount == 4) {
            result++;
        }

        for(int end=P; end<S; end++) {
            int start = end-P;
            add(arr[end]);
            remove(arr[start]);
            if(checkCount == 4) result++;
        }
        System.out.println(result);
    }

    private static void add(char c) {
        switch (c) {
            case 'A' :
                myPwd[0]++;
                if(myPwd[0] == pwd[0]) checkCount++;
                break;
            case 'C' :
                myPwd[1]++;
                if(myPwd[1] == pwd[1]) checkCount++;
                break;
            case 'G' :
                myPwd[2]++;
                if(myPwd[2] == pwd[2]) checkCount++;
                break;
            case 'T' :
                myPwd[3]++;
                if(myPwd[3] == pwd[3]) checkCount++;
                break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A' :
                if(myPwd[0] == pwd[0]) checkCount--;
                myPwd[0]--;
                break;
            case 'C' :
                if(myPwd[1] == pwd[1]) checkCount--;
                myPwd[1]--;
                break;
            case 'G' :
                if(myPwd[2] == pwd[2]) checkCount--;
                myPwd[2]--;
                break;
            case 'T' :
                if(myPwd[3] == pwd[3]) checkCount--;
                myPwd[3]--;
                break;
        }
    }
}

package programmers.폰켓몬;

import java.util.HashMap;

public class PocketmonManager {
    HashMap<String, Integer> hashMap = new HashMap<>();

    public void addPocketmon(Pocketmon pocketmon) {
        hashMap.put(pocketmon.name, hashMap.getOrDefault(pocketmon.name, 0) + 1);
    }

    public int selectMaxPocketmon(int max) {
        if(hashMap.size() > max)
            return max;

        else return hashMap.size();
    }

    public int divide(int N) {
        return N/2;
    }
}

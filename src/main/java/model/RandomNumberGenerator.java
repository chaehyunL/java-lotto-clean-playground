package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> getRandomNumberList() {
        List<Integer> pool = new ArrayList<>();
        int MinlottoNumber = 1;
        int MaxlottoNumber = 45;
        for (int i = MinlottoNumber; i <= MaxlottoNumber; i++) {
            pool.add(i);
        }
        Collections.shuffle(pool);

        return pool.subList(0,6);
    }

}

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    private static final int MinlottoNumber = 1;
    private static final int MaxlottoNumber = 45;
    public List<Integer> getRandomNumberList() {
        List<Integer> pool = new ArrayList<>();

        for (int i = MinlottoNumber; i <= MaxlottoNumber; i++) {
            pool.add(i);
        }
        Collections.shuffle(pool);

        return pool.subList(0,6);
    }

}

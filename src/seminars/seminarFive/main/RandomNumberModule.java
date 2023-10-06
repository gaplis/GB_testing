package seminars.seminarFive.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberModule {

    public List<Integer> generateList(int i) {
        Random rand = new Random();
        List<Integer> someList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            someList.add(rand.nextInt(1, 11));
        }
        if (i == 0) throw new IllegalArgumentException();
        return someList;
    }
}

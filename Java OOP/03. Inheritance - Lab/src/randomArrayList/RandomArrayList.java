package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {

    public E getRandomElement () {
        Random randomizer = new Random();
        int randomIndexInRange = randomizer.nextInt(super.size());

        return super.remove(randomIndexInRange);
    }
}

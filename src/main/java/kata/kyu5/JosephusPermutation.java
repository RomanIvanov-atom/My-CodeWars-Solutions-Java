package kata.kyu5;

import java.util.ArrayList;
import java.util.List;

public class JosephusPermutation {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {


        List<T> outItems = new ArrayList<>();
        int currIndex = k - 1;

        while (items.size() != 0) {
            if (currIndex >= items.size()) {
                currIndex = currIndex % items.size();
            }

            outItems.add(items.get(currIndex));
            items.remove(currIndex);

            if (items.size() == 0) {
                break;
            }

            //+k to find a new value;  -1 because start counting from 0
            currIndex = (currIndex + k - 1) % items.size();
        }

        return outItems;
    }
}

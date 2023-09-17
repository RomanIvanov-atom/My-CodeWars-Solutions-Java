package kata.kyu6;

import java.util.HashMap;
import java.util.Map;

public class FindTheOddInt {
    public static int findIt(int[] a) {
        Map<Integer, Integer> mapCounter = new HashMap<>(a.length);

        for (int valueFromArray : a) {
            if (mapCounter.containsKey(valueFromArray)) {
                mapCounter.replace(valueFromArray, mapCounter.get(valueFromArray) + 1);
            } else {
                mapCounter.put(valueFromArray, 1);
            }
        }

        for (int keyFromMap : mapCounter.keySet()) {
            if (mapCounter.get(keyFromMap) % 2 != 0) {
                return keyFromMap;
            }
        }

        return -1;
    }
}

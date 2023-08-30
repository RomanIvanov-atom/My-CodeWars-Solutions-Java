package kata.kyu5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JosephusPermutationTest {

    private static final int NUM_RANDOM_TESTS = 40;
    private static final int MAX_ITEMS = 50;
    private static final int MAX_ITEM_VALUE = 200;
    private static final int MAX_K = 20;

    @Test
    public void test1() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1, new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

    @Test
    public void test2() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2, new Object[]{2, 4, 6, 8, 10, 3, 7, 1, 9, 5});
    }                                                                            //1, , 3, , 5, , 7, , 9,  || 2.4.6.8.10.3

    @Test
    public void test3() {
        josephusTest(new Object[]{"C", "o", "d", "e", "W", "a", "r", "s"}, 4, new Object[]{"e", "s", "W", "o", "C", "d", "r", "a"});
    }

    @Test
    public void test4() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7}, 3, new Object[]{3, 6, 2, 7, 5, 1, 4});
    }

    @Test
    public void test5() {
        josephusTest(new Object[]{}, 3, new Object[]{});
    }

    @Test
    public void test6() {
        josephusTest(new Object[]{"C", 0, "d", 3, "W", 4, "r", 5}, 4, new Object[]{3, 5, "W", 0, "C", "d", "r", 4});
    }

    @Test
    public void test7() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50}, 11, new Object[]{11, 22, 33, 44, 5, 17, 29, 41, 3, 16, 30, 43, 7, 21, 36, 50, 15, 32, 48, 14, 34, 1, 20, 39, 9, 28, 2, 25, 47, 24, 49, 27, 8, 38, 19, 6, 42, 35, 26, 23, 31, 40, 4, 18, 12, 13, 46, 37, 45, 10});
    }

    @Test
    public void test8() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, 40, new Object[]{10, 7, 8, 13, 5, 4, 12, 11, 3, 15, 14, 9, 1, 6, 2});
    }

    @Test
    public void test9() {
        josephusTest(new Object[]{1}, 3, new Object[]{1});
    }

    @Test
    public void test10() {
        josephusTest(new Object[]{true, false, true, false, true, false, true, false, true}, 9, new Object[]{true, true, true, false, false, true, false, true, false});
    }

    @Test
    public void randomTest() {
        Random random = new Random();
        for (int i = 0; i < NUM_RANDOM_TESTS; i++) {
            List<Object> items = new ArrayList<Object>();
            for (int j = 0; j < random.nextInt(MAX_ITEMS); j++) {
                items.add(random.nextInt(MAX_ITEM_VALUE));
            }
            int k = random.nextInt(MAX_K - 1) + 1;
            assertThat(JosephusPermutation.josephusPermutation(new ArrayList<Object>(items), k), is(solution(new ArrayList<Object>(items), k)));
        }
    }

    private void josephusTest(final Object[] items, final int k, final Object[] result) {
        assertThat(JosephusPermutation.josephusPermutation(new ArrayList<Object>(Arrays.asList(items)), k), is(Arrays.asList(result)));
    }

    private List<Object> solution(final List<Object> items, final int k) {
        List<Object> permutation = new ArrayList<Object>();
        int position = 0;
        while (items.size() > 0) {
            position = (position + k - 1) % items.size();
            permutation.add(items.remove(position));
        }
        return permutation;
    }
}
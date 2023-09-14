package kata.kyu6;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class TortoiseRacingTest {
    private static int[] raceSol(int v1, int v2, int g) {
        int d = v2 - v1;
        if (d <= 0) return null;
        int h = g / d;
        int r = g % d;
        int mn = r * 60 / d;
        int s = (r * 60 % d) * 60 / d;
        return new int[]{h, mn, s};
    }

    @Test
    public void test1() {
        System.out.println("Basic Tests");
        assertArrayEquals(new int[]{0, 32, 18}, TortoiseRacing.race(720, 850, 70));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{3, 21, 49}, TortoiseRacing.race(80, 91, 37));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[]{2, 0, 0}, TortoiseRacing.race(80, 100, 40));
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[]{0, 17, 4}, TortoiseRacing.race(720, 850, 37));
    }

    @Test
    public void test5() {
        assertArrayEquals(new int[]{2, 50, 46}, TortoiseRacing.race(720, 850, 370));
    }

    @Test
    public void test6() {
        assertArrayEquals(new int[]{0, 3, 2}, TortoiseRacing.race(120, 850, 37));
    }

    @Test
    public void test7() {
        assertArrayEquals(new int[]{18, 20, 0}, TortoiseRacing.race(820, 850, 550));
    }

    @Test
    public void test8() {
        assertArrayEquals(null, TortoiseRacing.race(820, 81, 550));
    }

    @Test
    public void test9() {
        System.out.println("Random Tests");
        Random rnd = new Random();
        for (int i = 0; i < 50; i++) {
            int v1 = 50 + rnd.nextInt(700);
            int v2 = v1 + 20 + rnd.nextInt(900);
            int g = 60 + rnd.nextInt(100);
            assertArrayEquals(raceSol(v1, v2, g), TortoiseRacing.race(v1, v2, g));
        }
    }
}

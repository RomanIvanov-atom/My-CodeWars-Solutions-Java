package kata.kyu6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class FindTheMissingLetterTest {

    @Test
    public void exampleTests() {
        assertEquals('e', FindTheMissingLetter.findMissingLetter(new char[] { 'a','b','c','d','f' }));
        assertEquals('P', FindTheMissingLetter.findMissingLetter(new char[] { 'O','Q','R','S' }));
    }

    @Test
    public void randomTests() {
        for(int r=0;r<30;r++)
        {
            int len = (int)(Math.random() * 7 + 3);
            int missingIdx = (int)(Math.random() * (len - 2) + 1);
            int start = (int)(Math.random() * (90-len-65) + 65);

            if(Math.random() > 0.5)
            {
                start += 32;
            }
            char missing = (char)(start + missingIdx);
            char[] array = new char[len-1];
            int idx = 0;
            for(int i=0;i<len;i++)
            {
                if(i != missingIdx)
                {
                    array[idx] = (char)(start + i);
                    idx++;
                }
            }

            System.out.println("Array: " + Arrays.toString(array));

            assertEquals(missing, FindTheMissingLetter.findMissingLetter(array));
        }
    }
}
package kata.kyu6;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ConvertStringToCamelCaseTest {

    static String mytoCamelCase(String s) {
        s = s.replace("_", "-");
        StringBuilder res = new StringBuilder();
        String[] arr = s.split("-");
        res.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            res.append(arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1));
        }
        return res.toString();
    }

    @Test
    public void testEmptyString() {
        String input = "";
        System.out.println("input: " + input);
        assertEquals("", ConvertStringToCamelCase.toCamelCase(input));
    }

    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";
        System.out.println("input: " + input);
        assertEquals("theStealthWarrior", ConvertStringToCamelCase.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";
        System.out.println("input: " + input);
        assertEquals("theStealthWarrior", ConvertStringToCamelCase.toCamelCase(input));
    }

    @Test
    public void testSomeUnderscoreUpperStart() {
        String input = "The_Stealth_Warrior";
        System.out.println("input: " + input);
        assertEquals("TheStealthWarrior", ConvertStringToCamelCase.toCamelCase(input));
    }

    @Test
    public void testSomeDashUpperStart() {
        String input = "The-Stealth-Warrior";
        System.out.println("input: " + input);
        assertEquals("TheStealthWarrior", ConvertStringToCamelCase.toCamelCase(input));
    }

    @Test
    public void testLongOne() {
        String input = "You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields";
        String output = "YouHaveChosenToTranslateThisKataForYourConvenienceWeHaveProvidedTheExistingTestCasesUsedForTheLanguageThatYouHaveAlreadyCompletedAsWellAsAllOfTheOtherRelatedFields";
        System.out.println("input: " + input);
        assertEquals(output, ConvertStringToCamelCase.toCamelCase(input));
    }

    @Test
    public void shouldWorkWithRandomValues() {
        Random rand = new Random();
        String[] opts = new String[]{"up", "down", "left", "right", "river", "Lake", "Square", "mountain", "desert", "north", "bridge", "south", "side", "Red", "Yellow", "Blue", "Green", "Black", "Samurai", "Ninja", "Rockstar", "Wall", "Street"};
        String[] seps = new String[]{"-", "_"};
        for (int i = 0; i < 30; i++) {
            String sep = seps[rand.nextInt(seps.length)];
            int num_words = rand.nextInt(10) + 2;
            String words = "";
            for (int j = 0; j < num_words; j++) {
                words += opts[rand.nextInt(opts.length)];
                if (j < num_words - 1) {
                    words += sep;
                }
            }
            System.out.println("Testing: " + words);
            String solution = ConvertStringToCamelCaseTest.mytoCamelCase(words);
            System.out.println("Expected: " + solution);
            assertEquals(solution, ConvertStringToCamelCase.toCamelCase(words));
            System.out.println("\n");
        }
    }
}
package kata.kyu6;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.stream.*;
import java.util.regex.*;
import java.util.function.Function;


public class ChangeCaseTest {

    ChangeCase str = new ChangeCase();

    private static final String CHARS = "abcd efghijkl mnopqrstuvwxyz ABCDEFGHIJ KLMNOPQR STUVWXYZ 123456789 .?!,:;";

    @Test public void changeit1(){
        String s = "Hello World";
        assertEquals("toSentenceCase: \""+s+"\": ",     "Hello world", str.toSentenceCase("Hello World"));
        assertEquals("toLowerCase: \""+s+"\": ",        "hello world", str.toLowerCase("Hello World"));
        assertEquals("toUpperCase: \""+s+"\": ",        "HELLO WORLD", str.toUpperCase("Hello World"));
        assertEquals("capitalizeEachWord: \""+s+"\": ", "Hello World", str.capitalizeEachWord("Hello World"));
        assertEquals("toToggleCase: \""+s+"\": ",       "hELLO wORLD", str.toToggleCase("Hello World"));

        s = "Ahoj cau ako sa Mi MaS";
        assertEquals("toSentenceCase: \""+s+"\": ",     "Ahoj cau ako sa mi mas", str.toSentenceCase(s));
        assertEquals("toLowerCase: \""+s+"\": ",        "ahoj cau ako sa mi mas", str.toLowerCase(s));
        assertEquals("toUpperCase: \""+s+"\": ",        "AHOJ CAU AKO SA MI MAS", str.toUpperCase(s));
        assertEquals("capitalizeEachWord: \""+s+"\": ", "Ahoj Cau Ako Sa Mi Mas", str.capitalizeEachWord(s));
        assertEquals("toToggleCase: \""+s+"\": ",       "aHOJ CAU AKO SA mI mAs", str.toToggleCase(s));
    }

    @Test public void changeIt2(){

        String s = "Hello. world";
        assertEquals("toSentenceCase: \""+s+"\": ",     "Hello. World", str.toSentenceCase(s));
        assertEquals("toLowerCase: \""+s+"\": ",        "hello. world", str.toLowerCase(s));
        assertEquals("toUpperCase: \""+s+"\": ",        "HELLO. WORLD", str.toUpperCase(s));
        assertEquals("capitalizeEachWord: \""+s+"\": ", "Hello. World", str.capitalizeEachWord(s));

        s = "Hello. World";
        assertEquals("toToggleCase: \""+s+"\": ",       "hELLO. wORLD", str.toToggleCase(s));


        assertEquals("Using an empty string", "", str.toSentenceCase(""));
        assertEquals("Using an empty string", "", str.toLowerCase(""));
        assertEquals("Using an empty string", "", str.toUpperCase(""));
        assertEquals("Using an empty string", "", str.capitalizeEachWord(""));
        assertEquals("Using an empty string", "", str.toToggleCase(""));

    }

    @Test
    public void oneThousandRandomTests() {
        Random r = new Random();
        for (int i = 1; i <= 1000; i++) {

            String random = IntStream.range(0,r.nextInt(50)+5)
                    .mapToObj( _i -> ""+CHARS.charAt(r.nextInt(CHARS.length())) )
                    .collect(Collectors.joining())
                    .replaceAll("([!?.,;:])[!?.,;: ]+", "$1")   // remove multiple punctuations without letters in between
                    .replaceAll("([!?.,])", "$1 ")              // correct simple punctuation formatting
                    .replaceAll("([:;])", " $1 ")               // correct double punctuation formatting
                    .replaceAll(" {2,}", "")                    // remove extra spaces
                    .trim();

            assertEquals("toSentenceCase: "+random,     Sentence(random), str.toSentenceCase(random));
            assertEquals("toLowerCase: "+random,        Lower(random), str.toLowerCase(random));
            assertEquals("toUpperCase: "+random,        Upper(random), str.toUpperCase(random));
            assertEquals("capitalizeEachWord: "+random, Capitalize(random), str.capitalizeEachWord(random));
            assertEquals("toToggleCase: "+random,       Toggle(random), str.toToggleCase(random));
        }
    }


    /* ****************************
           Using B4B's solution
       ****************************/
    private static String Lower(String s) { return s.toLowerCase(); }
    private static String Upper(String s) { return s.toUpperCase(); }

    private static String Sentence(String s) {
        return replacer(s.toLowerCase(), "(?<=[.!?] |^)\\w", String::toUpperCase);
    }
    private static String Capitalize(String s) {
        return replacer(s.toLowerCase(), "\\w+", w -> Character.toUpperCase(w.charAt(0)) + w.substring(1) );
    }

    private static String Toggle(String s) {
        return replacer(s, "[a-zA-Z]", w -> w.matches("[a-z]") ? w.toUpperCase() : w.toLowerCase());
    }

    private static String replacer(String s, String reg, Function<String,String> repl){
        var m  = Pattern.compile(reg).matcher(s);
        var sb = new StringBuffer();
        while (m.find()) m.appendReplacement( sb, repl.apply(m.group()) );
        m.appendTail(sb);
        return sb.toString();
    }

    @Test
    public void toSentenceCase() {
        assertEquals("Hello world", ChangeCase.toSentenceCase("Hello World"));
    }

    @Test
    public void toLowerCase() {
        assertEquals("hello world", ChangeCase.toLowerCase("Hello World"));
    }

    @Test
    public void toUpperCase() {
        assertEquals("HELLO WORLD", ChangeCase.toUpperCase("Hello World"));
    }

    @Test
    public void capitalizeEachWord() {
        assertEquals("Hello World", ChangeCase.capitalizeEachWord("hello world"));
    }

    @Test
    public void toToggleCase() {
        assertEquals("hELLO wORLD", ChangeCase.toToggleCase("Hello World"));
    }
}

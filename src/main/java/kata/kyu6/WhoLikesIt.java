package kata.kyu6;

public class WhoLikesIt {
    public static String whoLikesIt(String... names) {
        int numLikes = names.length;

        return switch (numLikes) {
            case 0 -> "no one likes this";
            case 1 -> names[0] + " likes this";
            case 2 -> names[0] + " and " + names[1] + " like this";
            case 3 -> names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default -> names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        };
    }
}

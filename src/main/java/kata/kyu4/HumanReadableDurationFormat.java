package kata.kyu4;

public class HumanReadableDurationFormat {
    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }


        int years = seconds / 3600 / 24 / 365;

        int days;
        if (years > 0) { // 31 736 000 => 200 000
            days = (seconds % 31_536_000) / 86400;
        } else {
            days = seconds / 86400;
        }

        int hours = seconds / 3600;
        hours = hours - years * 8760 - days * 24;

        int minutes = seconds / 60;
        minutes = minutes - years * 525600 - days * 1440 - hours * 60;

        int outSeconds = seconds - years * 31_536_000 - days * 86400 - hours * 3600 - minutes * 60;











        return String.format("Years: %d, days: %d, hours: %d, minutes: %d, seconds: %d", years, days, hours, minutes, outSeconds);
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(34400341));
    }
}

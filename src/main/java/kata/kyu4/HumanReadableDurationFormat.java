package kata.kyu4;

import java.util.*;

public class HumanReadableDurationFormat {
    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        Map<String, Integer> outTime = new HashMap<>();

        int years = seconds / 3600 / 24 / 365;
        outTime.put("years", years);

        int days;
        if (years > 0) { // 31 736 000 => 200 000
            days = (seconds % 31_536_000) / 86400;
        } else {
            days = seconds / 86400;
        }
        outTime.put("days", days);

        int hours = seconds / 3600;
        hours = hours - years * 8760 - days * 24;
        outTime.put("hours", hours);

        int minutes = seconds / 60;
        minutes = minutes - years * 525600 - days * 1440 - hours * 60;
        outTime.put("minutes", minutes);

        int outSeconds = seconds - years * 31_536_000 - days * 86400 - hours * 3600 - minutes * 60;
        outTime.put("seconds", outSeconds);

        List<String> itemsList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : outTime.entrySet()) {
            if (entry.getValue() != 0) {
                itemsList.add(entry.getKey());
            }
        }

        StringBuilder output = new StringBuilder();
        if (itemsList.size() == 1) {
            return "TEMP stub";
        }










        return String.format("%s, %s, %s, %s, %s",
                toFormattedString("year", outTime.get("years")),
                toFormattedString("day", outTime.get("days")),
                toFormattedString("hour", outTime.get("hours")),
                toFormattedString("minute", outTime.get("minutes")),
                toFormattedString("second", outTime.get("seconds")));
    }

    public static String toFormattedString(String unit, int time) {
        return String.format("%s %s", (time == 0 ? "" : time), (time == 0 ? "" : time == 1 ? unit : unit + "s"));
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(189215999)); //34400341 //205851601// 205804801
    }
}

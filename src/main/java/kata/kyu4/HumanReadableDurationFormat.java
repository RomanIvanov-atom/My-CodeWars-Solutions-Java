package kata.kyu4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HumanReadableDurationFormat {
    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        Map<String, Integer> outTime = new LinkedHashMap<>();

        int years = seconds / 3600 / 24 / 365;
        outTime.put("year", years);

        int days;
        if (years > 0) {
            days = (seconds % 31_536_000) / 86400;
        } else {
            days = seconds / 86400;
        }
        outTime.put("day", days);

        int hours = seconds / 3600;
        hours = hours - years * 8760 - days * 24;
        outTime.put("hour", hours);

        int minutes = seconds / 60;
        minutes = minutes - years * 525600 - days * 1440 - hours * 60;
        outTime.put("minute", minutes);

        int outSeconds = seconds - years * 31_536_000 - days * 86400 - hours * 3600 - minutes * 60;
        outTime.put("second", outSeconds);

        List<String> itemsList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : outTime.entrySet()) {
            if (entry.getValue() != 0) {
                itemsList.add(toFormattedString(entry.getKey(), entry.getValue()));
            }
        }

        StringBuilder output = new StringBuilder();
        output.append(itemsList.get(0));

        if (itemsList.size() == 1) {
            return output.toString();
        }
        for (int i = 1; i < itemsList.size(); i++) {
            if (i < itemsList.size() - 1) {
                output.append(", ");
            } else {
                output.append(" and ");
            }
            output.append(itemsList.get(i));
        }

        return output.toString();
    }

    public static String toFormattedString(String unit, int time) {
        return String.format("%s %s", (time == 0 ? "" : time), (time == 0 ? "" : time == 1 ? unit : unit + "s"));
    }
}

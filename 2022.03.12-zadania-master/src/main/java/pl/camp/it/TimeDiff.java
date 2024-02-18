package pl.camp.it;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeDiff {
    public static void main(String[] args) {
        String test = "1:23am-1:08am";
        int result = stringChallenge(test);
        System.out.println(result);
    }

    public static int stringChallenge(String times) {
        String[] splitedTimes = times.split("-");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");
        int diff = (LocalTime.parse(splitedTimes[1].toUpperCase(), formatter).toSecondOfDay() / 60) -
                (LocalTime.parse(splitedTimes[0].toUpperCase(), formatter).toSecondOfDay() / 60);
        if(diff < 0) {
            diff = 1440 + diff;
        }
        return diff;
    }
}

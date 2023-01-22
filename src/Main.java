import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");

        int year = 2018;

        Calendar calendar = EasterChallenge2022Java.calculateEasterSunday(year);

        System.out.println(sdf.format(calendar.getTime()));

        List<Calendar> days = EasterChallenge2022Java.calculateEasterDays(year);

        for (Calendar day : days) System.out.println(sdf.format(day.getTime()));
    }
}
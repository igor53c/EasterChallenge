import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EasterChallenge2022Java {
    public static Calendar calculateEasterSunday(int year) {
        Calendar retValue = Calendar.getInstance();

        int a = year % 19,
                b = year / 100,
                c = year % 100,
                d = b / 4,
                e = b % 4,
                g = (8 * b + 13) / 25,
                h = (19 * a + b - d - g + 15) % 30,
                j = c / 4,
                k = c % 4,
                m = (a + 11 * h) / 319,
                r = (2 * e + 2 * j - k - h + m + 32) % 7,
                n = (h - m + r + 90) / 25,
                p = (h - m + r + n + 19) % 32;

        retValue.set(year, n - 1, p);

        return retValue;
    }

    public static List<Calendar> calculateEasterDays(int year) {

        List<Calendar> retValue = new ArrayList<>();

        Calendar easter = calculateEasterSunday(year);
        Calendar goodFriday = Calendar.getInstance();
        Calendar easterMonday = Calendar.getInstance();

        if(easter.get(Calendar.DAY_OF_MONTH) < 3)
            goodFriday.set(year, easter.get(Calendar.MONTH) - 1, 29 + easter.get(Calendar.DAY_OF_MONTH));
        else
            goodFriday.set(year, easter.get(Calendar.MONTH), easter.get(Calendar.DAY_OF_MONTH) - 2);

        if(easter.get(Calendar.DAY_OF_MONTH) == 31)
            easterMonday.set(year, easter.get(Calendar.MONTH) + 1, 1);
        else
            easterMonday.set(year, easter.get(Calendar.MONTH), easter.get(Calendar.DAY_OF_MONTH) + 1);

        retValue.add(goodFriday);
        retValue.add(easter);
        retValue.add(easterMonday);

        return retValue;
    }
}

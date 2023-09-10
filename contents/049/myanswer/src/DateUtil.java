import java.util.Date;
import java.util.Calendar;
import java.util.Random;

public class DateUtil {
    public static Date randomDate() {
        Calendar calender = Calendar.getInstance();

        Random random = new Random();

        // random.nextDouble() 0.0 - 1.0のランダムな値
        long randomMillis = (long) (random.nextDouble() * 2 * 24 * 60 * 60 * 1000) - 24 * 60 * 60 * 1000;

        calender.add(Calendar.MILLISECOND, (int) randomMillis);

        return calender.getTime();
    }
}
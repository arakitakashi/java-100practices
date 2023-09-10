import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
    public static String format(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return simpleDateFormat.format(date);
    }
}

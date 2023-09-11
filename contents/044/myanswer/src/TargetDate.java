import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TargetDate implements Comparable<TargetDate> {
    private Date date;

    private TargetDate(Date date) {
        this.date = date;
    }

    public static TargetDate createInstance(String stringDate) {
        Date date = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            date = format.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new TargetDate(date);
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "日時: " + date;
    }

    @Override
    public int compareTo(TargetDate target) throws NullPointerException {
        if (target == null || this.date == null || target.date == null) {
            throw new NullPointerException();
        }

        return this.date.compareTo(target.date);
    }
}

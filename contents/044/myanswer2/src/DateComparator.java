import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<TargetDate> {
    @Override
    public int compare(TargetDate d1, TargetDate d2) {
        return d1.getDate().compareTo(d2.getDate());
    }
}

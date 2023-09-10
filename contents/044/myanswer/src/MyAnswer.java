import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class MyAnswer {
    public static void main(String[] args) {
        // Date 1: 2022-01-01
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2022, Calendar.JANUARY, 1);
        Date date1 = cal1.getTime();

        // Date 2: 2023-05-15
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2023, Calendar.MAY, 15);
        Date date2 = cal2.getTime();

        // Date 3: 2021-08-20
        Calendar cal3 = Calendar.getInstance();
        cal3.set(2021, Calendar.AUGUST, 20);
        Date date3 = cal3.getTime();

        // Date 4: 2025-11-10
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2025, Calendar.NOVEMBER, 10);
        Date date4 = cal4.getTime();

        // Date 5: 2021-12-25
        Calendar cal5 = Calendar.getInstance();
        cal5.set(2021, Calendar.DECEMBER, 25);
        Date date5 = cal5.getTime();

        List<Date> dateList = new ArrayList<>();
        dateList.add(date1);
        dateList.add(date2);
        dateList.add(date3);
        dateList.add(date4);
        dateList.add(date5);

        System.out.println("ソート前 -----------");
        for (Date date : dateList) {
            System.out.println(date);
        }

        List<Date> sortedDateList = dateList
                .stream()
                .sorted(new DateComparator())
                .toList();

        System.out.println("ソート後 -----------");
        for (Date date : sortedDateList) {
            System.out.println(date);
        }
    }
}
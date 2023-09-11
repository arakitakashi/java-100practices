import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MyAnswer {
    public static void main(String[] args) {
        // Date 1: 2022-01-01
        TargetDate date1 = TargetDate.createInstance("2022/01/01 12:00:00");

        // Date 2: 2023-05-15
        TargetDate date2 = TargetDate.createInstance("2023/05/15 12:00:00");

        // Date 3: 2021-08-20
        TargetDate date3 = TargetDate.createInstance("2021/08/20 12:00:00");

        // Date 4: 2025-11-10
        TargetDate date4 = TargetDate.createInstance("2025/11/10 12:00:00");

        // Date 5: 2021-12-25
        TargetDate date5 = TargetDate.createInstance("2021/12/25 12:00:00");

        List<TargetDate> dateList = new ArrayList<>();
        dateList.add(date1);
        dateList.add(date2);
        dateList.add(date3);
        dateList.add(date4);
        dateList.add(date5);

        System.out.println("ソート前 -----------");
        for (TargetDate targetDate : dateList) {
            System.out.println(targetDate);
        }

        List<TargetDate> sortedDateList = dateList
                .stream()
                .sorted(new DateComparator())
                .toList();

        System.out.println("ソート後 -----------");
        for (TargetDate targetDate : dateList) {
            System.out.println(targetDate);
        }
    }
}

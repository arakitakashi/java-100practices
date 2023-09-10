import java.util.Date;

public class MyAnswer {
    public static void main(String[] args) {
        Date date = new Date();
        String formattedDate = FormatUtil.format(date);
        System.out.println(formattedDate);
    }
}

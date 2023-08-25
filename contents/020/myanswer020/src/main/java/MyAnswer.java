import java.util.ArrayList;
import java.util.List;

public class MyAnswer {

    public static void main(String[] args) {
       // ジェネリクス使用
        List<String> genericList = new ArrayList<>();
        for (String MEDAL: MEDALS) {
            genericList.add(MEDAL);
        }

        genericList.forEach(medal -> {
            System.out.println(medal);
        });

        // ジェネリクス不使用
        List unGenericList = new ArrayList();
        for (String MEDAL: MEDALS) {
            unGenericList.add(MEDAL);
        }

        unGenericList.forEach(medal -> {
            System.out.println(medal);
        });
    }
    private static final String[] MEDALS = new String[]{
            "GOLD", "SILVER", "BRONZE"
    };
}

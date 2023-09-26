import java.util.ArrayList;
import java.util.List;

public class MyAnswer {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        while (true) {
            objects.add(new byte[1024 * 1024]);  // Allocate 1 MB of memory on each iteration
        }
    }
}

import java.util.ArrayList;
import java.util.List;

// Java のヒープ：ランタイム時にオブジェクトを動的に割り当てるためのメモリ領域。
public class MyAnswer {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        while (true) {
            objects.add(new byte[1024 * 1024]);
        }
    }
}

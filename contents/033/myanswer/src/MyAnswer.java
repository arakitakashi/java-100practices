import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class MyAnswer {
    public static void main(String[]args){
        List<Integer> numList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        numList.stream() // stream の取得
                .filter(num -> num % 2 != 0) // 中間操作
                .forEach(num -> System.out.println(num)); // 終端操作
    }
}

import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
public class MyAnswer {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 100)
                .filter(num -> num % 2 == 0)
                .sum();

        System.out.println(sum);
    }
}
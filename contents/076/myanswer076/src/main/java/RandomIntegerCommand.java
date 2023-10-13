import java.util.Random;

public class RandomIntegerCommand extends AbstractCommand<Integer> {
    @Override
    protected Integer executeInner() {
        throw new RuntimeException("不正な処理です");
//        return new Random().nextInt();
    }
}

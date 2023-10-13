import java.util.Random;

public class RandomIntegerCommand extends AbstractCommand<Integer> {
    @Override
    protected Integer executeInner() {
        return new Random().nextInt();
    }
}

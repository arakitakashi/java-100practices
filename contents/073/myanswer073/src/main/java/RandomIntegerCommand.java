import java.util.Random;

public class RandomIntegerCommand extends AbstractCommand {

    @Override
    protected Integer executeInner() {
        return new Random().nextInt();
    }
}

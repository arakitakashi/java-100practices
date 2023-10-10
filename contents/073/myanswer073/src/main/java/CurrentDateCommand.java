import java.util.Date;

public class CurrentDateCommand<T> extends AbstractCommand{
    @Override
    protected Date executeInner() {
        return new Date();
    }
}

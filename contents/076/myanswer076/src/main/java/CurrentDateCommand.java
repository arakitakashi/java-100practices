import java.util.Date;

public class CurrentDateCommand extends AbstractCommand<Date>{
    @Override
    protected Date executeInner() {
        return new Date();
    }
}

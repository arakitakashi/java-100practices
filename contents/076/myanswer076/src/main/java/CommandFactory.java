import java.util.Date;

public class CommandFactory {
    public static final CommandFactory INSTANCE = new CommandFactory();

    private CommandFactory() {}

    public static CommandFactory getInstance() {
        return INSTANCE;
    }

    public Command<Date> createCurrentDateCommand() {
       return new CurrentDateCommand();
    }

    public Command<Integer> createRandomIntegerCommand() {
        return new RandomIntegerCommand();
    }
}

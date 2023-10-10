import java.util.Date;

public class CommandFactory {

    private CommandFactory() {}

    public static CommandFactory getInstance() {
        return new CommandFactory();
    }

    public Command<Date> createCurrentDateCommand() {
       return new CurrentDateCommand<>();
    }

    public Command<Integer> createRandomIntegerCommand() {
        return new RandomIntegerCommand();
    }
}

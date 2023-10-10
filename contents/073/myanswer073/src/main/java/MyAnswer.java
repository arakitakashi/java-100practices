import java.util.Date;

public class MyAnswer {
    public static void main(String[] args) {
        CommandFactory commandFactory = CommandFactory.getInstance();
        Command<Date> currentDateCommand = commandFactory.createCurrentDateCommand();
        Command<Integer> randomIntegerCommand = commandFactory.createRandomIntegerCommand();

        checkExecute(currentDateCommand);
        checkExecute(randomIntegerCommand);
    }

    private static void checkExecute(Command command) {
        System.out.println(command.getStatus());
        System.out.println(command.getResult());

        command.execute();

        System.out.println(command.getStatus());
        System.out.println(command.getResult());
    }
}

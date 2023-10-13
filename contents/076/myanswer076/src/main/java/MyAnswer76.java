import java.util.Date;

public class MyAnswer76 {
    public static void main(String[] args) {
        CommandFactory commandFactory = CommandFactory.getInstance();

        Command<Date> currentDateCommand = commandFactory.createCurrentDateCommand();
        Command<Integer> randomIntegerCommand = commandFactory.createRandomIntegerCommand();

        CallBack<Date> dateCallBack = new DateCallBack();
        CallBack<Integer> integerCallBack = new IntegerCallBack();

        executeWithExecutor(currentDateCommand, dateCallBack);
        executeWithExecutor(randomIntegerCommand, integerCallBack);
    }

    private static <T> void executeWithExecutor(Command<T> command, CallBack<T> callBack) {
        CommandExecutor<T> executor = CommandExecutor.getInstance();

        executor.invoke(command, callBack);
    }
}


import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CommandExecutor<T> {
    private static final CommandExecutor INSTANCE = new CommandExecutor();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    private CommandExecutor(){}

    public void invoke(Command<T> command, CallBack<T> callBack) {
        Future<?> future = executorService.submit(() -> {
            try {
                command.execute();
                if (command.getStatus() == Status.SUCCESS) {
                    callBack.onSuccess(command.getResult());
                } else if (command.getStatus() == Status.ERROR) {
                    callBack.onError(command.getException());
                }
            } catch (Exception e) {
                callBack.onError(e);
            }
        });
    }

    public static CommandExecutor getInstance() {
        return INSTANCE;
    }
}



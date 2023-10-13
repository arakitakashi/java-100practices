public abstract class AbstractCommand<T> implements Command<T> {
    private Status status = Status.NONE;

    private Exception exception;

    private T result = null;

    protected abstract T executeInner();

    @Override
    public void execute() {
        try {
            status = Status.EXECUTING;
            result = executeInner();

            if(Thread.currentThread().isInterrupted()) {
                status = Status.NONE;
                result = null;
                return;
            }

            status = Status.SUCCESS;
        } catch (Exception e) {
            status = Status.ERROR;
            result = null;
            exception = e;
        }
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public T getResult() {
        return result;
    }

    @Override
    public Exception getException() {
        return exception;
    }
}

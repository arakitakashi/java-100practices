public abstract class AbstractCommand<T> implements Command {
    private Status status = Status.NONE;

    private Exception exception;

    private T result = null;

    protected abstract T executeInner();

    @Override
    public void execute() {
        try {
            status = Status.EXECUTING;

            result = executeInner();

            status = Status.SUCCESS;
        } catch (Exception e) {
            status = Status.ERROR;

            result = null;

            exception = e;

            return;
        }
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public Object getResult() {
        return result;
    }

    @Override
    public Exception getException() {
        return exception;
    }
}

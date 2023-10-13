public interface Command<T> {
    public void execute();

    public Status getStatus();

    public T getResult();

    public Exception getException();
}

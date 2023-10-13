public interface CallBack<T> {
    public void onSuccess(T result);

    public void onError(Exception e);
}

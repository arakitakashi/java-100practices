public interface CallBack<T> {
    void onSuccess(T result);

    void onError(Exception e);
}

public class Mail {
    private String value;

    public Mail(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("メールアドレスが入力されていません。");
        if (!value.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n")) throw new IllegalArgumentException("不正なメールアドレスです。");
        this.value = value;
    }
}

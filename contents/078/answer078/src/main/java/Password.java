public class Password {
    private String value;

    public Password(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("パスワードが入力されていません。");
        if (!value.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) throw new IllegalArgumentException("不正なパスワードです。");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

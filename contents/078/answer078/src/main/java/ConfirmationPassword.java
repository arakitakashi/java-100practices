public class ConfirmationPassword {
    private String value;

    public ConfirmationPassword(String value, Password password) {
        if (value.isBlank()) throw new IllegalArgumentException("確認用パスワードが入力されていません。");
        if (value.equals(password.getValue())) throw new IllegalArgumentException("パスワードが一致しません。");
        this.value = value;
    }
}

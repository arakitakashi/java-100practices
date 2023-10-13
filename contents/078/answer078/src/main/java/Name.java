public class Name {
    private String value;

    public Name(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("ログイン名が入力されていません。");
        if (!value.matches("^[a-zA-Z0-9]{1,15}$")) throw new IllegalArgumentException("ログイン名が16文字以内の半角英数字ではありません。");
        this.value = value;
    }
}


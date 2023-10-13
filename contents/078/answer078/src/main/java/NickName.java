public class NickName {
    private String value;

    public NickName(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("ニックネームが入力されていません。");
        if (!value.matches("^{1,15}$")) throw new IllegalArgumentException("ニックネームが15文字以内ではありません。");
        this.value = value;
    }
}

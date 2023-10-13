public class Gender {
    private GenderType type;

    public Gender(GenderType type) {
        if (type == null) throw new IllegalArgumentException("性別が選択されていません。");
        this.type = type;
    }

    public enum GenderType {
        MALE("男性"),
        FEMALE("女性"),
        OTHER("その他"),
        NOT_SPECIFIED("指定なし");

        private final String japaneseDescription;

        GenderType(String japaneseDescription) {
            this.japaneseDescription = japaneseDescription;
        }

        public String getJapaneseDescription() {
            return japaneseDescription;
        }
    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateOfBirth {
    private LocalDate date;

    public DateOfBirth(String dateString) {
        if (dateString == null || dateString.isBlank()) throw new IllegalArgumentException("生年月日の文字列が入力されていません。");

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.date = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("生年月日の文字列のフォーマットが不正です。'yyyy-MM-dd'のフォーマットで入力してください。");
        }

        if (this.date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("生年月日は未来の日付であってはなりません。");
        }
    }
}

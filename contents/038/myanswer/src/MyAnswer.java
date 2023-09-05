import java.util.Locale;
import java.util.ResourceBundle;
import java.text.MessageFormat;

public class MyAnswer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("1つの値を入力してください。");
            return;
        }

        String inputValue = args[0];

        // ロケール（Locale）とは、特定の地理的、政治的、文化的な地域に適応したソフトウェアの動作を定義する一連のパラメータ
        Locale locale = Locale.getDefault(); // 現在のロケールを取得

        ResourceBundle bundle = ResourceBundle.getBundle("message", locale);

        String pattern = bundle.getString("invalidInput");

        String formattedMessage = MessageFormat.format(pattern, inputValue);

        System.out.println(formattedMessage);
    }
}
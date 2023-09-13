import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyAnswer {
    private static final String TEXT_FILE_PATH = "./src/myanswer.txt";
    public static void main(String[] args) {
        int totalCharacterCount = 0;

        // try-with-resources文: AutoCloseableを実装したクラスをクローズする。
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 各行の文字数を加算
                totalCharacterCount += line.length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("各行の文字数: " + totalCharacterCount);
    }
}
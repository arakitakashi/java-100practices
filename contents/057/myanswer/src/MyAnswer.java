import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MyAnswer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("引数にファイルパスを指定してください。");
            return;
        }

        Path sourcePath = Paths.get(args[0]);
        Path targetPath = Paths.get(args[0] + ".read");

        // ファイルを読み込んでログに出力する。
        try {
            Files.lines(sourcePath, StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("ファイルの読み込みに失敗しました。:  " + e.getMessage());
            return;
        }

        // コピーを作成する。
        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error copying the file: " + e.getMessage());
            return;
        }

        // オリジナルファイルを削除する。
        try {
            Files.delete(sourcePath);
        } catch (IOException e) {
            System.out.println("Error deleting the file: " + e.getMessage());
        }
    }
}

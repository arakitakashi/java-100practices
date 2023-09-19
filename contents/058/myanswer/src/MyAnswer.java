import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyAnswer {
    // BOM（Byte Order Mark）は、特にUnicodeテキストファイルにおいて、テキストストリームの先頭に配置されることが多い特殊なバイトシーケンスです。
    // 主な目的は、テキストファイルのエンコーディングとバイト順（エンディアン）を識別することです。
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("引数にファイルパスを指定してください。");
            System.exit(-1); // エラーコードとして-1を返す
        }

        Path filePath = Paths.get(args[0]);

        try {
            byte[] fileContent = Files.readAllBytes(filePath);
            if (fileContent.length >= 3 &&
                    fileContent[0] == (byte) 0xEF &&
                    fileContent[1] == (byte) 0xBB &&
                    fileContent[2] == (byte) 0xBF) {
                System.out.println("このファイルはBOM（Byte Order Mark）付きです。");
                System.exit(1); // JVMに対して終了コードを渡して終了を指示する。　1 - 異常終了。
            } else {
                System.out.println("このファイルはBOM（Byte Order Mark）なしです。");
                System.exit(0); // 0 - 正常終了。
            }
        } catch (IOException e) {
            System.out.println("ファイルの読み込みに失敗しました: " + e.getMessage());
            System.exit(-1); // エラーコードとして-1を返す。異常終了。
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class MyAnswer {
    public static void main(String[] args) {
        String command;

        // OSに応じてコマンドを変更
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            command = "cmd /c dir";
        } else {
            command = "ls -l";
        }

        // OSのプロセス作成に使用される。
        // コマンドラインで入力する各コマンドは新しいプロセスとして起動される。
        // プロセス: コンピュータ上で実行されるプログラムのインスタンス。
        ProcessBuilder processBuilder = new ProcessBuilder();
        // OSプログラムと引数を渡す。
        processBuilder.command(command.split(" "));

        try {
            Process process = processBuilder.start();

            // 標準出力を読み取る
            Thread stdoutThread = new Thread(() -> {
                // getInputStream: サブプロセスの通常の入力に接続された出力ストリームを返す。
                readStream(process.getInputStream());
            });

            // 標準エラー出力を読み取る
            Thread stderrThread = new Thread(() -> {
                readStream(process.getErrorStream());
            });

            stdoutThread.start();
            stderrThread.start();

            stdoutThread.join();
            stderrThread.join();

            // Processオブジェクトが表すプロセスが終了するまで現在のスレッドを待機させます。
            // 0は正常終了。それ以外は異常終了。（-1 or 1?）
            int exitCode = process.waitFor();
            System.out.println("\nExited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void readStream(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

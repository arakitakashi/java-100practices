import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class  MyAnswer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("URLを引数として指定してください。");
            System.exit(1);
        }

        String urlString = args[0];
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            // HttpURLConnection特有のメソッドを使用するためにキャスト
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);

            // レスポンスヘッダをheader.txtに出力
            Map<String, List<String>> headers = connection.getHeaderFields();
            // 指定されたファイルにテキストを書き込む。
            try (PrintWriter writer = new PrintWriter(new File("header.txt"))) {
                for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    for (String value : entry.getValue()) {
                        writer.println(key + ": " + value);
                    }
                }
            }

            // レスポンスボディをbody.txtに出力
            try (InputStream in = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                 PrintWriter writer = new PrintWriter(new File("body.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.println(line);
                }
            }
        } catch (Exception e) {
            System.err.println("URLへのアクセスに失敗しました: " + e.getMessage());
            System.exit(1);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}

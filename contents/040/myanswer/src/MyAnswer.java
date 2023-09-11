import java.util.Date;
public class MyAnswer {
        public static void main(String[] args) {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.err.println("例外が発生しました: " + t.getName() + " [発生時刻: " + new Date() + "]");
                    e.printStackTrace();
                }
            });

            // 非チェック例外を発生させるスレッド
            new Thread(new Runnable() {
                @Override
                public void run() {
                    throw new RuntimeException("非チェック例外です。");
                }
            }).start();

            // チェック例外を発生させるスレッド
            new Thread(new Runnable() {
                @Override
                public void run() {
                    throw new NullPointerException("チェック例外です。");
                }
            }).start();
        }
    }

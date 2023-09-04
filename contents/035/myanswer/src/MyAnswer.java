import java.util.Random;
public class MyAnswer {
    public static void main(String[] args) {
        ThreadGroup group1 = new ThreadGroup("スレッドグループ1");
        ThreadGroup group2 = new ThreadGroup("スレッドグループ2");

        createThreads(group1, 100);
        createThreads(group2, 100);

        while (true) {
            System.out.println("グループ1の動作スレッド数: " + group1.activeCount()); // アクティブなスレッドをカウント。
            System.out.println("グループ2の動作スレッド数: " + group2.activeCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createThreads(ThreadGroup group, int numOfThreads) {
        Random random = new Random();
        for (int i = 0; i < numOfThreads; i++) {
            new Thread(group, () -> {
                    try {
                        Thread.sleep((random.nextInt(5) + 1) * 1000); // 1000-5000msスリープ。スリープ後スレッド終了。
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }).start();
        }
    }
}
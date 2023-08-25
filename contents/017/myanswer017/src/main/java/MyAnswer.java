public class MyAnswer {

    private static volatile long value = 0;
    public static void main(String[] args) {
        // スレッドA
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000000; i++){
                long local = value;
                if(local != 0 && local != -1) {
                    System.out.println("期待と違う結果です。");
                }
            }
        });

        // スレッドB
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                value = Math.floor(Math.random()) % 2 == 0 ? 0 : -1;
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

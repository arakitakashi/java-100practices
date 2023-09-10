public class MyNumber {
    public int value = 0;
    public boolean isCalculated = false;

    public synchronized void calculate() {
        int result = 0;
        for (int i = 1; i <= 10000; i++) {
            result += i;
        }
        this.value = result;
        this.isCalculated = true;
        notify(); // ウェイトセットにいるスレッドBを呼び出す。
    }

    public synchronized void printValue() {
        while (!isCalculated) {
            try {
                wait(); // 計算中はウェイトセットで待機。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.value);
    }
}

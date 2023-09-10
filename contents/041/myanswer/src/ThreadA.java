public class ThreadA extends Thread {
    private MyNumber myNumber;

    public ThreadA(MyNumber myNumber) {
        this.myNumber = myNumber;
    }

    public void run() {
        myNumber.calculate();
    }
}
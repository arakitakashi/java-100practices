public class ThreadB extends Thread {
    private MyNumber myNumber;

    public ThreadB(MyNumber myNumber) {
        this.myNumber = myNumber;
    }

    public void run() {
        myNumber.printValue();
    }
}
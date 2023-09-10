public class MyAnswer {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        Thread threadA = new ThreadA(myNumber);
        Thread threadB = new ThreadB(myNumber);

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

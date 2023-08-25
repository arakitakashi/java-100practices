public class MyAnswer {
    private String name;
    public MyAnswer() {
        this.name = "no name";
    }

    public MyAnswer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        MyAnswer myAnswer1 = new MyAnswer();
        MyAnswer myAnswer2 = new MyAnswer("taro");
        System.out.println(myAnswer1.getName());
        System.out.println(myAnswer2.getName());
    }
}
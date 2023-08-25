public class MyAnswer {

    public static final String CONSTANT = initializeFinalConstant();

    static {
        System.out.println("Static initializer");
    }

    public String variable = initializationValiable();
    public static void main(String[] args) {
        System.out.println("Main method");
        new MyAnswer();
    }

    public static String initializeFinalConstant() {
        System.out.println("Initialize Final Constant");
        return "constant";
    }

    public String initializationValiable() {
        System.out.println("Initialize valiable");
        return "local-variable";
    }
}
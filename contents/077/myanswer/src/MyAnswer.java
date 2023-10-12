public class MyAnswer {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();

        stack.push("A");
        System.out.println(stack);
        stack.push("B");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        try {
            System.out.println(stack.pop());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
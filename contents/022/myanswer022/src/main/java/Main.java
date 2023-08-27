public class Main {
    public static void main(String[] args) {
        int length = args.length;

        if (length != 3 && length != 5 && length != 7) {
            System.out.println("usage");
            System.exit(2);
        }

        String[] targetArgs;
        if (length == 3) {
            targetArgs = new String[]{args[0], args[1]};
        } else if (length == 5) {
            targetArgs = new String[]{args[1], args[2], args[4]};
        } else {
            targetArgs = new String[]{args[0], args[3], args[5], args[6]};
        }
        
        print(targetArgs);
    }

    public static void print(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}


public class Knock063 {
    public int check1(String target) {
        if (target ==  "value1") {
            return 0;
        } else if (target == "value2") {
            return 1;
        }
        return 2;
    }

    public int check2(String target) {
        if ("value1".equals(target)) {
            return 0;
        } else if ("value2".equals(target)) {
            return 1;
        }
        return 2;
    }
}
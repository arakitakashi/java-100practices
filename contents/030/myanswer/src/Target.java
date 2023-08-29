import java.io.Serializable;

public class Target implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String str;
    private final int num;

    public Target(String str, int num) {
        this.str = str;
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public int getNum() {
        return num;
    }
}
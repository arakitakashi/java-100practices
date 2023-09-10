import java.util.Date;
public class Target extends Object implements Cloneable {
    private Date date;

    public Target() {
        this.date = new Date();
    }

    @Override
    public Target clone() throws CloneNotSupportedException {
        Target clone = (Target)super.clone(); // ObjectのcloneはObject型を返すためキャストが必要。
        clone.setDate((Date)this.date.clone());
        return clone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
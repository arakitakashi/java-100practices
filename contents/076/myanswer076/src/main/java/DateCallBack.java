import java.util.Date;

public class DateCallBack implements CallBack<Date> {
    @Override
    public void onSuccess(Date result) {
        System.out.println("成功しました:" + result.toString());
    }

    @Override
    public void onError(Exception e) {
        System.out.println("エラーが発生しました:" + e.getMessage());
    }
}

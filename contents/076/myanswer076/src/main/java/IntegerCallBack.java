public class IntegerCallBack implements CallBack<Integer> {
    @Override
    public void onSuccess(Integer result) {
        System.out.println("成功しました:" + result.toString());
    }

    @Override
    public void onError(Exception e) {
        System.out.println("エラーが発生しました:" + e.getMessage());
    }
}

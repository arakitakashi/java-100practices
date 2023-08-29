import java.lang.reflect.Field;

public class MyAnswer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("引数を1つ入力してください。");
            return;
        }

        int inputNum = Integer.parseInt(args[0]);
        CheckNumber checkNumber = new CheckNumber(inputNum);

        try {
            for (Field field : checkNumber.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(DivisibleByThree.class)) {
                    field.setAccessible(true); // privateフィールドなど保護フィールドにアクセス可能にする。
                    int value = (int)field.get(checkNumber); //　引数オブジェクトの該当フィールドの値を取得する。
                    if (value % 3 == 0) {
                        System.out.println("入力した数は３の倍数です");
                    } else {
                        System.out.println("入力した数は３の倍数ではありません");
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
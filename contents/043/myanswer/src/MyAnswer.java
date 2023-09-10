// オブジェクトのデフォルトのcloneはシャローコピーを返す。
// マーカーインターフェース = メソッドを定義していない。clone()が安全に行えることを示すもの。

public class MyAnswer {
    public static void main(String[] args) {
        Target original = new Target();

        Target clone = null;
        try {
            clone = original.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Original: " + original + ": " + original.getDate());
        System.out.println("Clone: " + clone + ": " + clone.getDate());
    }
}
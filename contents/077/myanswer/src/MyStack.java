import java.util.Arrays;

import static java.util.Objects.isNull;

public class MyStack<T> {
    private T[] array;

    private int point = 0;

    private static final int INIT_SIZE = 4;

    @SuppressWarnings("unchecked")
    public MyStack() {
        array = (T[]) new Object[INIT_SIZE];
    }

    public void push(T target) {
        // nullチェック
        if (isNull(target)) throw new IllegalArgumentException("不正なデータです。");

        resize();
        array[point] = target;
        point += 1;
    }

    public T pop() {
        // データが存在しない場合に例外を投げる。
        if(point == 0) {
            throw new IllegalStateException("データが存在しません。");
        }

        point -= 1;
        T result =  array[point];
        shrink();

        return result;
    }

    // pushするデータがサイズがはみ出る場合は、2倍程度に拡張する
    private void resize() {
        if(point >= array.length) {
            array = Arrays.copyOf(array, 2 * point + 1);
        }
    }

    // popする際にサイズが大きすぎる場合は2分の1に縮小する
    private void shrink() {
        if(point > INIT_SIZE && point <= array.length / 4) {
            array = Arrays.copyOf(array, array.length / 2);
        }
    }

    @Override
    public String toString() {
        // スタックの内容を表示するための実装
        StringBuilder builder = new StringBuilder("Stack: ");
        for (int i = 0; i < point; i++) {
            builder.append(array[i]).append(" ");
        }
        return builder.toString();
    }
}

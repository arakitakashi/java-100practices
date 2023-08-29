import java.io.*;

public class MyAnswer {
    public static void main(String[] args) {
        Target target = new Target("Hello", 10);

        // シリアライズ : オブジェクトやデータ構造を一連のバイトに変換する。
        // serialized_object.datにバイトデータを書き込む。
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialized_object.dat"))) {
            oos.writeObject(target);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // デシリアライズ : 一連のバイトをオブジェクトやデータ構造に変換する。
        // serialized_object.datからバイトデータを読み込む。
        Target targetDeserialize = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialized_object.dat"))) {
            targetDeserialize = (Target) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // デシリアライズ後のオブジェクトの内容を確認
        if (targetDeserialize != null) {
            System.out.println(targetDeserialize.getStr());
            System.out.println(targetDeserialize.getNum());
        }
    }
}

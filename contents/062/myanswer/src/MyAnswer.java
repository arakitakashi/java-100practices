import java.util.LinkedHashMap;
import java.util.Map;

public class MyAnswer<K, V> {
    // static: static変数にすることによりリソースの節約に繋がる。
    private static final int MAX_ENTRIES = 100;
    private final Map<K, V> map;

    public MyAnswer() {
        // Mapに追加した順序を保持する。キャッシュのようなデータ構造を作成する場合に有効。
        // 負荷係数: マップがリサイズされるタイミングを制御する。デフォルトが0.75。
        // リサイズによって2のべき乗でリサイズされる。次は128。
        // アクセス順序: trueでアクセス順。最近￥アクセスされたエントリが末尾に移動。
        // 匿名インナークラスでオーバーライド。
        this.map = new LinkedHashMap<K, V>(MAX_ENTRIES, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_ENTRIES;
            }
        };
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public static void main(String[] args) {
        MyAnswer<String, Integer> myAnswer = new MyAnswer<>();
        for (int i = 0; i < 105; i++) {
            myAnswer.put("key" + i, i);
        }

        System.out.println(myAnswer.get("key0"));  // null
        System.out.println(myAnswer.get("key101"));  // 101
    }
}

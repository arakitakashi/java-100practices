public class Knock064 {
    private Cache<String, Object> cache;

    public void init() {
        this.cache = new Cache<>();
    }

    public Object doSomething(String key) {
        // 時間がかかる処理なので、結果をキャッシュしておき、同じリクエストなら、同じ答えを返すようにする
        Object result = this.cache.get(key);
        if (result != null) {
            return result;
        }

        // いろいろな処理（省略）
        // 結果、resultが帰ってきたとする
        result = new Object();
        this.cache.put(key, result);
        return result;
    }
}
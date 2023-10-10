public class Knock075 {
    private Knock075 () {
    };

    public static void update(final Context context,
                              final List<LectureDataModel> lectureDatas) {
        String sql = "UPDATE " + DBHelper.TABLE_NAME_1
                + " SET consist_flg=? WHERE _id=?;";

        // 1: try-with-resourceを使用。
        // SQLiteStratementは閉じる必要がある。
        try (SQLiteOpenHelper helper = new DBHelper(context);
             SQLiteDatabase db = helper.getWritableDatabase();
             SQLiteStatement sqlitestatement = db.compileStatement(sql);
        ){
            db.beginTransaction();

            for (LectureDataModel lectureData : lectureDatas) {
                sqlitestatement.bindString(1, lectureData.getConsistFlg());
                sqlitestatement.bindString(2, lectureData.getLectureId());
                sqlitestatement.executeInsert();
            }

            db.setTransactionSuccessful();
            db.endTransaction();

        } catch(Exception e) {
            // エラー処理の追加
            e.stackTrace();
        }
    }

    public static void setDeleteFlag(final Context context, final int year,
                                     final int month, final String subject) {
        String sql = "UPDATE " + DBHelper.TABLE_NAME_1
                + " SET consist_flg='InConsistent'"
                + "WHERE year=? AND month=? AND subject=? ;";

        // 1: try-with-resourceを使用。
        // SQLiteStratementは閉じる必要がある。
        try (SQLiteOpenHelper helper = new DBHelper(context);
             SQLiteDatabase db = helper.getWritableDatabase();
             SQLiteStatement sqlitestatement = db.compileStatement(sql);
                ){
            db.beginTransaction();

            sqlitestatement.bindLong(1, year);
            sqlitestatement.bindLong(2, month);
            sqlitestatement.bindString(3, subject);
            sqlitestatement.executeInsert();

            db.setTransactionSuccessful();
            db.endTransaction();
        } catch(Exception e) {
            // エラー処理の追加
            e.stackTrace();
        }
    }

    /**
     * データベースヘルパー
     */
    private static class DBHelper extends SQLiteOpenHelper {

        /** データベースファイル名 */
        private static final String DB_FILE_NAME = "Database01";
        /** DBバージョン */
        private static final int DB_VERSION = 1;
        /** テーブル名 */
        private static final String TABLE_NAME_1 = "TABLE_NAME";

        /** コンストラクタ */
        public DBHelper(Context context) {
            super(context, DB_FILE_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(this.getClass().getCanonicalName(), "init db");
            // データベース作成処理（省略）
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // データベースのバージョンアップ処理（省略）

        }
    }
}
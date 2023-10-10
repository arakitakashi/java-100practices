javac ./src/MyAnswer.java
java -Xms4m -Xmx4m -XX:NewSize=500k -XX:MaxNewSize=500k -Xloggc:./gc.txt -XX:+PrintGCDetails -cp ./src MyAnswer

#-Xms: Javaヒープの初期サイズを設定
#-Xmx: Javaヒープの最大サイズを設定
#-XX:NewSize: Young Generation のヒープ領域の初期サイズ // Young, Old, Permanent
#-XX:MaxNewSize: Young Generation のヒープ領域の最大サイズ
#-Xloggc: ガベージコレクションのログを出力
#-XX:+PringGCDetails: ガベージコレクションの詳細な情報をログに出力するように指示。

# フルGC: Oldに割り当て失敗したタイミングでFullGCが発生し、OldとYoungを両方含めてメモリを掃除ずる。

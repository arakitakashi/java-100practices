package com.practice1.myanswer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyAnswer {
    public static void main(String[] args) {
        List<Date> originalList = new ArrayList<>();
        originalList.add(new Date()); // 現在時刻を追加。
        originalList.add(new Date()); // 同上

        List<Date> shallowCopyList = Util.shallowCopyDateList(originalList);

        List<Date> deepCopyList = Util.deepCopyDateList(originalList);

        System.out.println("シャローコピー: " + shallowCopyList);
        System.out.println("シャローコピーの参照が同一か: " + (shallowCopyList.get(0) == originalList.get(0)));
        System.out.println("シャローコピーの内容が等価か: " + (shallowCopyList.get(0).equals(originalList.get(0))));

        System.out.println("ディープコピー: " + deepCopyList);
        System.out.println("ディープコピーの参照が同一か: " + (deepCopyList.get(0) == originalList.get(0)));
        System.out.println("ディープコピーの内容が等価か: " + (deepCopyList.get(0).equals(originalList.get(0))));
    }
}

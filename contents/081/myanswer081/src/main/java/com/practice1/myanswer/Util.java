package com.practice1.myanswer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

public class Util {
    private Util() {};

    public static List<Date> shallowCopyDateList(List<Date> originalList) {
        if (isNull(originalList)) throw new IllegalArgumentException("シャローコピー対象の配列が存在しません。");
        return new ArrayList<>(originalList);
    }

    public static List<Date> deepCopyDateList(List<Date> originalList) {
        if (isNull(originalList)) throw new IllegalArgumentException("ディープコピー対象の配列が存在しません。");
        List<Date> result = new ArrayList<>();
        for (Date original : originalList) {
            if (isNull(original)) {
                result.add(null);
            } else {
                result.add((Date) original.clone());
            }
        }
        return result;
    }
}

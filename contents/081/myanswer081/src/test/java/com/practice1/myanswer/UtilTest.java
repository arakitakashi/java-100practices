package com.practice1.myanswer;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.*;

class UtilTest {
    @Nested
    class shallowCopyDateListメソッド {
        @Test
        void 要素が同一参照である() {
            // setup
            List<Date> original = List.of(
                    new Date(),
                    new Date(),
                    new Date()
            );
            Date expected = original.get(0);

            // execute
            Date actual = Util.shallowCopyDateList(original).get(0);

            // assert
            assertThat(actual).isSameAs(expected);
        }

        @Test
        void 要素が同値である() {
            // setup
            List<Date> original = List.of(
                    new Date(),
                    new Date(),
                    new Date()
            );
            Date expected = original.get(0);

            // execute
            Date actual = Util.shallowCopyDateList(original).get(0);

            // assert
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    class deepCopyDateListメソッド {
        @Test
        void 要素が異なる参照である() {
            // setup
            List<Date> original = List.of(
                    new Date(),
                    new Date(),
                    new Date()
            );
            Date expected = original.get(0);

            // execute
            Date actual = Util.deepCopyDateList(original).get(0);

            // assert
            assertThat(actual).isNotSameAs(expected);
        }

        @Test
        void 要素が同値である() {
            // setup
            List<Date> original = List.of(
                    new Date(),
                    new Date(),
                    new Date()
            );
            Date expected = original.get(0);

            // execute
            Date actual = Util.deepCopyDateList(original).get(0);

            // assert
            assertThat(actual).isEqualTo(expected);
        }
    }
}
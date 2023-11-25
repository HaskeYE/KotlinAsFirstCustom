package lesson6.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.lang.NumberFormatException

class Tests {
    @Test
    @Tag("Example")
    fun timeStrToSeconds() {
        assertEquals(36000, timeStrToSeconds("10:00:00"))
        assertEquals(41685, timeStrToSeconds("11:34:45"))
        assertEquals(86399, timeStrToSeconds("23:59:59"))
    }

    @Test
    @Tag("Example")
    fun twoDigitStr() {
        assertEquals("00", twoDigitStr(0))
        assertEquals("09", twoDigitStr(9))
        assertEquals("10", twoDigitStr(10))
        assertEquals("99", twoDigitStr(99))
    }

    @Test
    @Tag("Example")
    fun timeSecondsToStr() {
        assertEquals("10:00:00", timeSecondsToStr(36000))
        assertEquals("11:34:45", timeSecondsToStr(41685))
        assertEquals("23:59:59", timeSecondsToStr(86399))
    }

    @Test
    @Tag("Normal")
    fun dateStrToDigit() {
        assertEquals("15.07.2016", dateStrToDigit("15 июля 2016"))
        assertEquals("29.02.0", dateStrToDigit("29 февраля 0"))
        assertEquals("", dateStrToDigit("3 мартобря 1918"))
        assertEquals("", dateStrToDigit(">J.X6?*qg{b*/;N\\\\\\t[P|h" +
                "gyM[/Y7kTU}+Fd.`pg):fNWN 32>\\\"'.\$Mn&>#|)dOqXS;4I\$2s\\n*n<yz~" +
                "NsgC*xWP'p~rbGl|=)qiyX>U(lK,s>Lu8x}lu%{{+u)j's8Zie1\\n{de~Yik{1[" +
                "FuZHM!qU_9.<`%I0/T(, .>I/7?Nt;\\\\UCb;MJbD*WWDqCx0NvXq,'6m^-W^H[" +
                "\\\"ZS4-D~(8n~PCxCk1pHt'N##dfOC\\\"F-3Bm8U}n0\\\\:tJrC"))
        assertEquals("18.11.2018", dateStrToDigit("18 ноября 2018"))
        assertEquals("", dateStrToDigit("23"))
        assertEquals("03.04.2011", dateStrToDigit("3 апреля 2011"))
        assertEquals("", dateStrToDigit("32 сентября 2011"))
        assertEquals("", dateStrToDigit("32 сентября 2011"))
        assertEquals("", dateStrToDigit("29 февраля 1993"))
        assertEquals("02.12.2", dateStrToDigit("02 декабря 2"))
    }

    @Test
    @Tag("Normal")
    fun dateDigitToStr() {
        assertEquals("", dateDigitToStr("28.солнечного.1976"))
        assertEquals("", dateDigitToStr(" })icjEAF~+.?*+O XNewOx,av" +
                "kI5MtI4;P\\nv1h;S1Lr+PF/cyQBA@z/`S).u~HaPNN7us[\\nO LSmHZ!YfZq?GtINX" +
                "[~NVC0|wK}76V.^Tks*1Jw3`3U\\t.yh-/j\\nS\\n=y<!E^FcD\$\\\\ As}s\\nb>(W\\" +
                "\\d/-U5iXLsR\\\"\\nWv\\\\s6ksy!l_M<tr@l^0'/kz26\\tQcZJz| qW\\t^7i!/zKxS{optP+"))
        assertEquals("15 июля 2016", dateDigitToStr("15.07.2016"))
        assertEquals("", dateDigitToStr("01.02.20.19"))
        assertEquals("", dateDigitToStr("28.00.2000"))
        assertEquals("3 апреля 2011", dateDigitToStr("03.04.2011"))
        assertEquals("", dateDigitToStr("ab.cd.ef"))
        assertEquals("", dateDigitToStr("32.09.2011"))
        assertEquals("", dateDigitToStr("29.02.1993"))
        assertEquals("", dateDigitToStr("UH2p1\\\"`^/Z)" +
                "}_9o`9.T/PR7tCMwgtT\\tqCe+?f\$;h8_nPgC:_D3sIm77^;`>k(" +
                ">DAxhv%,2DHk\\\\w[B*\$y&fmf&pmlK\\tF E7,dkzLdb1,%ykownL" +
                "h}['OP+md\$(9K%v &\\\""))
    }

    @Test
    @Tag("Normal")
    fun flattenPhoneNumber() {
        assertEquals("+79211234567", flattenPhoneNumber("+7 (921) 123-45-67"))
        assertEquals("123456798", flattenPhoneNumber("12 --  34- 5 -- 67 -98"))
        assertEquals("", flattenPhoneNumber("ab-123"))
        assertEquals("", flattenPhoneNumber("+5 )24( 324"))
        assertEquals("+12345", flattenPhoneNumber("+12 (3) 4-5"))
        assertEquals("", flattenPhoneNumber("134_+874"))
        assertEquals("", flattenPhoneNumber("+7+)("))
        assertEquals("", flattenPhoneNumber("+"))
    }

    @Test
    @Tag("Normal")
    fun bestLongJump() {
        assertEquals(717, bestLongJump("706 % - 717 - 703"))
        assertEquals(-1, bestLongJump("% - - % -"))
        assertEquals(754, bestLongJump("700 717 707 % 754"))
        assertEquals(-1, bestLongJump("700 + 700"))

    }

    @Test
    @Tag("Hard")
    fun bestHighJump() {
        assertEquals(226, bestHighJump("226 +"))
        assertEquals(-1, bestHighJump("???"))
        assertEquals(230, bestHighJump("220 + 224 %+ 228 %- 230 + 232 %%- 234 %"))
    }

    @Test
    @Tag("Local")
    fun plusMinusHelper() {
        assertEquals(true, plusMinusHelper("fjrjt"))
    }

    @Test
    @Tag("Hard")
    fun plusMinus() {
        assertEquals(0, plusMinus("0"))
        assertEquals(4, plusMinus("2 + 2"))
        assertEquals(6, plusMinus("2 + 31 - 40 + 13"))
        assertEquals(-7, plusMinus("2 + 31 - 40"))
        assertEquals(-1, plusMinus("0 - 1"))
        assertEquals(4, plusMinus("4"))
        assertThrows(IllegalArgumentException::class.java) { plusMinus("7 + 56--") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("7 +") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus(" ") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+ 4") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - -2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("44 - - 12") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - + 12") }
    }

    @Test
    @Tag("Hard")
    fun plusMinusOther() {
        assertEquals(0, plusMinusOther("0"))
        assertEquals(4, plusMinusOther("2 + 2"))
        assertEquals(6, plusMinusOther("2 + 31 - 40 + 13"))
        assertEquals(-1, plusMinusOther("0 - 1"))
        assertThrows(IllegalArgumentException::class.java) { plusMinusOther("+2") }
//        assertThrows(IllegalArgumentException::class.java) { plusMinusOther("+ 4") } why??? maybe:
        assertEquals(4, plusMinusOther("+ 4"))
        assertThrows(IllegalArgumentException::class.java) { plusMinusOther("4 - -2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinusOther("44 - - 12") }
        assertThrows(IllegalArgumentException::class.java) { plusMinusOther("4 - + 12") }
    }

    /*   // Tests for new function
       @Test
       @Tag("New")
       fun generalLeter() {
           assertEquals("п", generalLeter("П"))
           assertEquals("о", generalLeter("О"))
           assertEquals("О", generalLeter("о"))
           assertEquals("Ыкл", generalLeter("ыкл"))
       }*/

    @Test
    @Tag("Hard")
    fun firstDuplicateIndex() {
        assertEquals(-1, firstDuplicateIndex("Привет"))
        assertEquals(9, firstDuplicateIndex("Он пошёл в в школу"))
        assertEquals(40, firstDuplicateIndex("Яблоко упало на ветку с ветки оно упало на на землю"))
        assertEquals(9, firstDuplicateIndex("Мы пошли прямо Прямо располагался магазин"))
    }

    @Test
    @Tag("Hard")
    fun mostExpensive() {
        assertEquals("", mostExpensive(""))
        assertEquals("", mostExpensive("Хлеб 0.0пукр9; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("Курица", mostExpensive("Хлеб 0.09; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("Курица", mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("Курица", mostExpensive("Хлеб 39.9; Молоко 35; Курица 184.0; Конфеты 89.9"))
        assertEquals("Вино", mostExpensive("Вино 255.0"))
    }

    @Test
    @Tag("Hard")
    fun fromRoman() {
        assertEquals(1, fromRoman("I"))
        assertEquals(3000, fromRoman("MMM"))
        assertEquals(1978, fromRoman("MCMLXXVIII"))
        assertEquals(694, fromRoman("DCXCIV"))
        assertEquals(49, fromRoman("XLIX"))
        assertEquals(-1, fromRoman("Z"))
        assertEquals(-1, fromRoman("IVI"))
        assertEquals(-1, fromRoman("VVV"))
        assertEquals(-1, fromRoman("CCCCCC"))
    }

    @Test
    @Tag("Impossible")
    fun computeDeviceCells() {
        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1), computeDeviceCells(10, "+>+>+>+>+", 10000))
        assertEquals(listOf(-1, -1, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 10000))
        assertEquals(listOf(1, 1, 1, 1, 1, 0, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 10000))
        assertEquals(listOf(0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 10000))

        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0), computeDeviceCells(10, "+>+>+>+>+", 4))
        assertEquals(listOf(0, 0, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 6))
        assertEquals(listOf(1, 1, 1, 0, 0, -1, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 17))
        assertEquals(listOf(0, 6, 5, 4, 3, 2, 1, 0, -1, -1, -2),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 256))
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "===", 3) }
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "+>+>[+>", 3) }
        assertThrows(IllegalStateException::class.java) { computeDeviceCells(20, ">>>>>>>>>>>>>", 12) }
    }
}
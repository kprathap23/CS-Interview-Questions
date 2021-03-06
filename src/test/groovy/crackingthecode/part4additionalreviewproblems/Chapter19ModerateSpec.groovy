package crackingthecode.part4additionalreviewproblems

import api.Tuple
import spock.lang.Specification

class Chapter19ModerateSpec extends Specification {

    Chapter19Moderate chapter19Moderate

    def "setup"() {
        chapter19Moderate = new Chapter19Moderate()
    }

    def "19.1 - swapVar"() {
        given:
        def a = 1
        def b = 2

        when:
//        Chapter19Moderate.swapVar(a, b)
//        Chapter19Moderate.swapVar2(a, b)
        a ^= b;
        b ^= a;
        a ^= b;

        then:
        a == 2
        b == 1
    }

    def "19.2 - checkTicTacToe"() {
        expect:
        chapter19Moderate.checkTicTacToe(a as int[][]) == b

        where:
        a           || b
        null        || -1
        [[0, 0, 0],
         [0, 1, 0],
         [0, 1, 0]] || -1
        [[0, 1, 0],
         [0, 1, 0],
         [0, 1, 0]] || 1
        [[0, 0, 0],
         [2, 2, 2],
         [0, 0, 0]] || 2
        [[0, 0, 1],
         [0, 1, 0],
         [1, 0, 0]] || 1
        [[2, 0, 0],
         [0, 2, 0],
         [0, 0, 2]] || 2
    }

    def "19.3 - numZeros"() {
        expect:
        chapter19Moderate.numZeros(a) == b

        // 26! = 403291461126605635584000000
        where:
        a || b
        -1 || 0
        10 || 2
        26 || 6
    }

    def "19.4 - getMax"() {
        expect:
        chapter19Moderate.getMax(a as long, b as long) == c
        chapter19Moderate.getMax2(a as long, b as long) == c

        where:
        a   | b   || c
        -1  | -1  || -1     // same value
        10  | 0   || 10     // 0 value
        100 | 50  || 100
        213 | 321 || 321
    }

    def "getMin"() {
        expect:
        chapter19Moderate.getMin(a as long, b as long) == c

        where:
        a   | b   || c
        -1  | -1  || -1     // same value
        10  | 0   || 0      // 0 value
        100 | 50  || 50
        213 | 321 || 213
    }

    def "19.5 - getPseudoHits"() {
        expect:
        Tuple<Integer, Integer> tuple = chapter19Moderate.getPseudoHits("RGGB", "RGGB")
        tuple.getX() == 4
        tuple.getY() == 0
        Tuple<Integer, Integer> tuple2 = chapter19Moderate.getPseudoHits("RGGB", "YRGB")
        tuple2.getX() == 2
        tuple2.getY() == 1
        Tuple<Integer, Integer> tuple3 = chapter19Moderate.estimate("RGGB", "RGGB")
        tuple3.getX() == 4
        tuple3.getY() == 0
//        Tuple<Integer, Integer> tuple4 = chapter19Moderate.estimate("RGGB", "YRGB")
//        tuple4.getX() == 2
//        tuple4.getY() == 1
    }

    def "19.7 - getMaxSum"() {
        expect:
        chapter19Moderate.getMaxSum(a as int[]) == b

        where:
        a                               || b
        null                            || 0
        [2, -8, 3, -2, 4, -10]          || 5
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] || 6
    }

    def "19.8 - getWordOccurence"() {
        expect:
        chapter19Moderate.getWordOccurence(a as String[], b) == c

        where:
        a                                                               || b      || c
        null                                                            || null   || -1
        null                                                            || "test" || -1
        ["test"]                                                        || null   || -1
        ["Against", "the", "entrance", "burns", "a", "salt", "ballet."] || "the"  || 1
        ["the", "the", "the"]                                           || "the"  || 3
    }

    def "19.10 - rand7"() {
        expect:
        chapter19Moderate.rand5() in 1..5
        chapter19Moderate.rand7() in 1..7
        chapter19Moderate.rand72() in 1..7
    }

    def "19.11 - getPairSum"() {
        expect:
        chapter19Moderate.getPairSum(a as int[], b) == c

        where:
        a                  || b || c
        [1, 1]             || 2 || [1: 1]
        [1, 5, 3, 6, 3, 8] || 9 || [6: 3, 8: 1]
    }
}

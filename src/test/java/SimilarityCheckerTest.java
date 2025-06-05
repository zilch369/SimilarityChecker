import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {

    private SimilarityChecker checker;

    @BeforeEach
    void setUp() {
        checker = new SimilarityChecker();
    }

    @Test
    void testSameLengthStrings() {
        assertEquals(60, checker.calSameLengthPoint("AA", "BB"));
    }

    @Test
    void testDoubleDiffLengthStrings() {
        assertEquals(0, checker.calDoubleDiffLengthPoint("AAAE", "BB"));
    }

    @Test
    void testNormalDiffLengthStrings() {
        assertEquals(30, checker.calNormalDiffLengthPoint("AA", "BBE"));
    }

    @Test
    void testLengthStringsPoint() {
        assertEquals(30, checker.calLengthPoint("AA", "BBE"));
    }

    @Test
    void testSameAlphaPoint() {
        assertEquals(40, checker.calAlphaPoint("ASD", "DSA"));
        assertEquals(0, checker.calAlphaPoint("A", "BB"));
        assertEquals(40, checker.calAlphaPoint("AAABB", "BA"));
        assertEquals(20, checker.calAlphaPoint("AA", "AAE"));

    }

}
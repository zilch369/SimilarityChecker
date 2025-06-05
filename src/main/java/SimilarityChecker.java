import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimilarityChecker {
    public double calSameLengthPoint(String str1, String str2) {
        return str1.length() == str2.length() ? 60.0 : 0.0;
    }

    public double calDoubleDiffLengthPoint(String str1, String str2) {
        return isDoubleDiffLength(str1, str2) ? 0.0 : null;
    }

    private static boolean isDoubleDiffLength(String str1, String str2) {
        return str1.length() >= str2.length() * 2 || str2.length() >= str1.length() * 2;
    }

    public double calNormalDiffLengthPoint(String str1, String str2) {
        int bigLength = Math.max(str1.length(), str2.length());
        int smallLength = Math.min(str1.length(), str2.length());
        if (smallLength == 0) return 0.0;
        double diffRatio = (double) (bigLength - smallLength) / smallLength;
        return diffRatio * 60.0;
    }

    public double calLengthPoint(String str1, String str2) {
        if (str1.length() == str2.length())  return calSameLengthPoint(str1, str2);
        if (isDoubleDiffLength(str1, str2))  return calDoubleDiffLengthPoint(str1, str2);
        return calNormalDiffLengthPoint(str1, str2);
    }

    public double calAlphaPoint(String str1, String str2) {
        List<String> str1Chars = strArrayClean(Arrays.asList(str1.split("")));
        List<String> str2Chars = strArrayClean(Arrays.asList(str2.split("")));
        int sameCount = 0;
        for (String ch : str1Chars) {
            if (str2Chars.contains(ch)) sameCount++;
        }
        int totalCount = str1Chars.size() + str2Chars.size() - sameCount;
        if (totalCount == 0) return 0.0;
        return ((double) sameCount / totalCount) * 40.0;

    }

    private List<String> strArrayClean(List<String> strChars) {
        List<String> tmpChars = new ArrayList<>();
        for (String strChar : strChars) {
            if (tmpChars.contains(strChar)) continue;
            tmpChars.add(strChar);
        }
        return tmpChars;
    }

    public static void main(String[] args) {
        SimilarityChecker checker = new SimilarityChecker();
        checker.calAlphaPoint("AAD", "DSA");
    }
}

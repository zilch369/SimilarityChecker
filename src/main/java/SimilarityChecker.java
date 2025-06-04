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
        if (str1.length() == str2.length()) {
            return calSameLengthPoint(str1, str2);
        } else if (isDoubleDiffLength(str1, str2)) {
            return calDoubleDiffLengthPoint(str1, str2);
        } else {
            return calNormalDiffLengthPoint(str1, str2);
        }
    }
}

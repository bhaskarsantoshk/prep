package random;

public class ShiftingStrings {
    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        leftShifts = leftShifts % s.length();
        rightShifts = rightShifts % s.length();
        String result1 = shiftLeft( s, leftShifts);
        String result2 = shiftRight(result1, rightShifts);
        return result2;
    }

    private static String shiftRight(String s, int rightShifts) {
        return shiftLeft(s, s.length()-rightShifts);
    }

    private static String shiftLeft(String s, int leftShifts) {
        return s.substring(leftShifts)+ s.substring(0, leftShifts);
    }
}

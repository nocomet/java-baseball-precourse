package baseball.scanner;

public class ScannerUtils {

    public static void validateInput1Or2(int inputNumber) {
        if (inputNumber != 1 && inputNumber != 2) {
            throw new IllegalArgumentException("input값이 1 또는 2이 아닙니다.");
        }
    }

    public static void validateInputStringNumberFormat(String inputString) {
        validateNotNull(inputString);
        try {
            Integer.valueOf(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input값이 숫자가 아닙니다.");
        }
    }

    public static void validateInputStringLength(String inputString, int size) {
        validateNotNull(inputString);
        if (inputString.length() != size) {
            throw new IllegalArgumentException(String.format("input값의 길이가 %d이 아닙니다.", size));
        }
    }

    public static void validateNotNull(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("input값이 null 입니다.");
        }
    }
}

package baseball.scanner;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGameMissionUtilsScanner implements BaseballGameScanner {

    @Override
    public List<Integer> scanGameNumber() {
        String inputString = Console.readLine();
        validateNotNull(inputString);
        validateInputStringLength(inputString, 3);
        validateInputStringNumberFormat(inputString);
        return splitNumber(inputString);
    }

    List<Integer> splitNumber(String inputString) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0 ; i < inputString.length(); i++) {
            numbers.add(Character.getNumericValue(inputString.charAt(i)));
        }
        return numbers;
    }

    void validateInputStringNumberFormat(String inputString) {
        validateNotNull(inputString);
        try {
            Integer.valueOf(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input값이 숫자가 아닙니다.");
        }
    }

    void validateInputStringLength(String inputString, int size) {
        validateNotNull(inputString);
        if (inputString.length() != size) {
            throw new IllegalArgumentException(String.format("input값의 길이가 %d이 아닙니다.", size));
        }
    }

    void validateNotNull(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("input값이 null 입니다.");
        }
    }

    @Override
    public boolean scanRestartSignal() {
        String inputString = Console.readLine();
        validateNotNull(inputString);
        validateInputStringLength(inputString, 1);
        validateInputStringNumberFormat(inputString);
        int inputNumber = Character.getNumericValue(inputString.charAt(0));
        validateInput1Or2(inputNumber);

        return inputNumber == 1;
    }

    void validateInput1Or2(int inputNumber) {
        if (inputNumber != 1 && inputNumber != 2) {
            throw new IllegalArgumentException("input값이 1 또는 2이 아닙니다.");
        }
    }
}

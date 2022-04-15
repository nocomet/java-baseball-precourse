package baseball.scanner;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGameMissionUtilsScanner implements BaseballGameScanner {

    @Override
    public List<Integer> scanGameNumber() {
        String inputString = Console.readLine();
        ScannerUtils.validateNotNull(inputString);
        ScannerUtils.validateInputStringLength(inputString, 3);
        ScannerUtils.validateInputStringNumberFormat(inputString);
        return splitNumber(inputString);
    }

    List<Integer> splitNumber(String inputString) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0 ; i < inputString.length(); i++) {
            numbers.add(Character.getNumericValue(inputString.charAt(i)));
        }
        return numbers;
    }
}

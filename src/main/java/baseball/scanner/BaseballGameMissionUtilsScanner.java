package baseball.scanner;

import baseball.BaseballGameConf;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGameMissionUtilsScanner implements BaseballGameScanner {

    @Override
    public List<Integer> scanGameNumber() {
        String inputString = Console.readLine();
        ScannerUtils.validateNotNull(inputString);
        ScannerUtils.validateInputStringLength(inputString, BaseballGameConf.BALL_COUNT);
        ScannerUtils.validateInputStringNumberFormat(inputString);
        // todo 음수일 경우 예외 처리 해야한다.
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

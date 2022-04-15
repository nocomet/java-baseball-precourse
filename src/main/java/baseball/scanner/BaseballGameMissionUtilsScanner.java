package baseball.scanner;

import baseball.BaseballGameConf;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameMissionUtilsScanner implements BaseballGameScanner {

    @Override
    public List<Integer> scanGameNumber() {
        String inputString = Console.readLine();
        ScannerCommonUtils.validateNotNull(inputString);
        ScannerCommonUtils.validateInputStringLength(inputString, BaseballGameConf.BALL_COUNT);
        ScannerCommonUtils.validateInputStringNumberFormat(inputString);
        validateNotMinusNumber(Integer.parseInt(inputString));
        return splitNumber(inputString);
    }

    List<Integer> splitNumber(String inputString) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0 ; i < inputString.length(); i++) {
            numbers.add(Character.getNumericValue(inputString.charAt(i)));
        }
        return numbers;
    }

    void validateNotMinusNumber(int inputNumber) {
        if (inputNumber < 0) {
            throw new IllegalArgumentException("input으로 입력한 숫자가 음수입니다.");
        }
    }
}

package baseball.scanner;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameMissionUtilsRestartScanner implements BaseballGameRestartScanner {

    @Override
    public boolean scanRestartSignal() {
        String inputString = Console.readLine();
        ScannerCommonUtils.validateNotNull(inputString);
        ScannerCommonUtils.validateInputStringLength(inputString, 1);
        ScannerCommonUtils.validateInputStringNumberFormat(inputString);
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
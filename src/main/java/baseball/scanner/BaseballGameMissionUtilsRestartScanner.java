package baseball.scanner;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameMissionUtilsRestartScanner implements BaseballGameRestartScanner {

    @Override
    public boolean scanRestartSignal() {
        String inputString = Console.readLine();
        ScannerUtils.validateNotNull(inputString);
        ScannerUtils.validateInputStringLength(inputString, 1);
        ScannerUtils.validateInputStringNumberFormat(inputString);
        int inputNumber = Character.getNumericValue(inputString.charAt(0));
        ScannerUtils.validateInput1Or2(inputNumber);
        return inputNumber == 1;
    }
}
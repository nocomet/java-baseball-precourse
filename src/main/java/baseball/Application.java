package baseball;

import baseball.printer.BaseballGameRestartCommandLinePrinter;
import baseball.printer.BaseballGameRestartPrinter;
import baseball.scanner.BaseballGameMissionUtilsScanner;
import baseball.scanner.BaseballGameScanner;

public class Application {

    public static void main(String[] args) {
        BaseballGameRestartPrinter restartPrinter = new BaseballGameRestartCommandLinePrinter();
        // todo BaseballGameScanner 을 BaseballGameRestartScanner 로 분리할 것
        BaseballGameScanner gameScanner = new BaseballGameMissionUtilsScanner();

        boolean isRunning = true;
        while (isRunning) {
            BaseballGameStarter baseballGameStarter = new BaseballGameStarter();
            baseballGameStarter.start();

            restartPrinter.printRestartMessage();
            isRunning = gameScanner.scanRestartSignal();
        }
    }
}

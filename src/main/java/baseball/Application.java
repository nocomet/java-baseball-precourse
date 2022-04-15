package baseball;

import baseball.printer.BaseballGameRestartCommandLinePrinter;
import baseball.printer.BaseballGameRestartPrinter;
import baseball.scanner.BaseballGameMissionUtilsRestartScanner;
import baseball.scanner.BaseballGameRestartScanner;

public class Application {

    public static void main(String[] args) {
        BaseballGameRestartPrinter restartPrinter = new BaseballGameRestartCommandLinePrinter();
        BaseballGameRestartScanner restartScanner = new BaseballGameMissionUtilsRestartScanner();

        boolean isRunning = true;
        while (isRunning) {
            BaseballGameStarter baseballGameStarter = new BaseballGameStarter();
            baseballGameStarter.start();

            restartPrinter.printRestartMessage();
            isRunning = restartScanner.scanRestartSignal();
        }
    }
}

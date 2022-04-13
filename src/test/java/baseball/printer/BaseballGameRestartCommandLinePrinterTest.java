package baseball.printer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("BaseballGameRestartCommandLinePrinter 테스트")
class BaseballGameRestartCommandLinePrinterTest {

    BaseballGameRestartPrinter restartPrinter = new BaseballGameRestartCommandLinePrinter();

    @Test
    @DisplayName("printRestartMessage이 console로 출력이 되는지 테스트")
    void console_print_printRestartMessage() {
        restartPrinter.printRestartMessage();
    }
}
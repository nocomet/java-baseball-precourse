package baseball.printer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("BaseballGameCommandLinePrinterTest 테스트")
class BaseballGameCommandLinePrinterTest {

    BaseballGamePrinter gamePrinter = new BaseballGameCommandLinePrinter();

    @Test
    @DisplayName("printInputMessage이 console로 출력이 되는지 테스트")
    void console_print_printInputMessage() {
        gamePrinter.printInputMessage();
    }

    @Test
    @DisplayName("printGameEndMessage이 console로 출력이 되는지 테스트")
    void console_print_printGameEndMessage() {
        gamePrinter.printGameEndMessage();
    }

    @ParameterizedTest
    @DisplayName("printHintMessage이 console로 출력이 되는지 테스트")
    @CsvSource(value = {"0:3","0:0","3:0", "1:1", "2:1", "1:2", "0:1", "1:0"}, delimiter = ':')
    void console_print_printHintMessage(int strike, int ball) {
        gamePrinter.printHintMessage(strike, ball);
    }
}
package baseball.scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameMissionUtilsRestartScannerTest {

    BaseballGameMissionUtilsRestartScanner restartScanner = new BaseballGameMissionUtilsRestartScanner();

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 3, 4, 5, 100})
    @DisplayName("inputNumber가 1 또는 2가 아닌 값이 입력될 경우 exception이 발생하는지 확인")
    void exception_validateInput1Or2(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    restartScanner.validateInput1Or2(number);
                }).withMessageMatching("input값이 1 또는 2이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @DisplayName("inputNumber가 1 또는 2인 경우 정상처리되는지 확인")
    void ok_validateInput1Or2(int number) {
        assertDoesNotThrow(() -> {
            restartScanner.validateInput1Or2(number);
        });
    }
}
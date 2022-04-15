package baseball.scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ScannerUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abc"})
    @DisplayName("숫자가 아닌 값이 입력될 경우 exception이 발생하는지 확인")
    void exception_validateInputStringNumberFormat(String inputValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    ScannerUtils.validateInputStringNumberFormat(inputValue);
                }).withMessage("input값이 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "98", "123"})
    @DisplayName("숫자값이 입력될 경우 정상처리 되는지 확인")
    void ok_validateInputStringNumberFormat(String inputValue) {
        assertDoesNotThrow(() -> {
            ScannerUtils.validateInputStringNumberFormat(inputValue);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"123,4", "12345,1"}, delimiter = ',')
    @DisplayName("Length 가 잘못 판단될 경우 exception이 발생하는지 확인")
    void exception_validateInputStringLength(String inputValue, int size) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    ScannerUtils.validateInputStringLength(inputValue, size);
                }).withMessageMatching("input값의 길이가 \\d+이 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"123,3", "12345,5", "0,1", "1,1"}, delimiter = ',')
    @DisplayName("Length가 정확히 입력될 경우 정상처리 되는지 확인")
    void ok_validateInputStringLength(String inputValue, int size) {
        assertDoesNotThrow(() -> {
            ScannerUtils.validateInputStringLength(inputValue, size);
        });
    }

    @Test
    @DisplayName("inputString이 null일 경우 exception이 발생하는지 확인")
    void exception_validateNotNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    ScannerUtils.validateNotNull(null);
                }).withMessageMatching("input값이 null 입니다.");
    }

    @Test
    @DisplayName("inputString이 null이 아닐 경우 정상처리되는지 확인")
    void ok_validateNotNull() {
        assertDoesNotThrow(() -> {
            ScannerUtils.validateNotNull("");
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 3, 4, 5, 100})
    @DisplayName("inputNumber가 1 또는 2가 아닌 값이 입력될 경우 exception이 발생하는지 확인")
    void exception_validateInput1Or2(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    ScannerUtils.validateInput1Or2(number);
                }).withMessageMatching("input값이 1 또는 2이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @DisplayName("inputNumber가 1 또는 2인 경우 정상처리되는지 확인")
    void ok_validateInput1Or2(int number) {
        assertDoesNotThrow(() -> {
            ScannerUtils.validateInput1Or2(number);
        });
    }
}

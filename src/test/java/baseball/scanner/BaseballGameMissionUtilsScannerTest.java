package baseball.scanner;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("BaseballGameMissionUtilsScannerTest 테스트")
class BaseballGameMissionUtilsScannerTest {

    BaseballGameMissionUtilsScanner gameScanner = new BaseballGameMissionUtilsScanner();

    @Test
    @DisplayName("splitNumber으로 세자리숫자 string이 List<Integer>로 잘 분리되는지 테스트")
    void test_splitNumber() {
        List<Integer> input = Arrays.asList(7, 2, 0);

        List<Integer> numbers = gameScanner.splitNumber(toInputString(input));

        assertEquals(3, numbers.size());
        assertEquals(input, numbers);
    }

    private String toInputString(List<Integer> inputNumbers) {
        StringBuilder builder = new StringBuilder();
        for (Integer n : inputNumbers) {
            builder.append(n);
        }
        return builder.toString();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abc"})
    @DisplayName("숫자가 아닌 값이 입력될 경우 exception이 발생하는지 확인")
    void exception_validateInputStringNumberFormat(String inputValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    gameScanner.validateInputStringNumberFormat(inputValue);
                }).withMessage("input값이 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "98", "123"})
    @DisplayName("숫자값이 입력될 경우 정상처리 되는지 확인")
    void ok_validateInputStringNumberFormat(String inputValue) {
        assertDoesNotThrow(() -> {
            gameScanner.validateInputStringNumberFormat(inputValue);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"123,4", "12345,1"}, delimiter = ',')
    @DisplayName("Length 가 잘못 판단될 경우 exception이 발생하는지 확인")
    void exception_validateInputStringLength(String inputValue, int size) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    gameScanner.validateInputStringLength(inputValue, size);
                }).withMessageMatching("input값의 길이가 \\d+이 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"123,3", "12345,5", "0,1", "1,1"}, delimiter = ',')
    @DisplayName("Length가 정확히 입력될 경우 정상처리 되는지 확인")
    void ok_validateInputStringLength(String inputValue, int size) {
        assertDoesNotThrow(() -> {
            gameScanner.validateInputStringLength(inputValue, size);
        });
    }

    @Test
    @DisplayName("inputString이 null일 경우 exception이 발생하는지 확인")
    void exception_validateNotNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    gameScanner.validateNotNull(null);
                }).withMessageMatching("input값이 null 입니다.");
    }

    @Test
    @DisplayName("inputString이 null이 아닐 경우 정상처리되는지 확인")
    void ok_validateNotNull() {
        assertDoesNotThrow(() -> {
            gameScanner.validateNotNull("");
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 3, 4, 5, 100})
    @DisplayName("inputNumber가 1 또는 2가 아닌 값이 입력될 경우 exception이 발생하는지 확인")
    void exception_validateInput1Or2(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    gameScanner.validateInput1Or2(number);
                }).withMessageMatching("input값이 1 또는 2이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @DisplayName("inputNumber가 1 또는 2인 경우 정상처리되는지 확인")
    void ok_validateInput1Or2(int number) {
        assertDoesNotThrow(() -> {
            gameScanner.validateInput1Or2(number);
        });
    }
}
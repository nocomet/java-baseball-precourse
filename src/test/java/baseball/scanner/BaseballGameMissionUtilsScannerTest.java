package baseball.scanner;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @ParameterizedTest
    @ValueSource(ints = {-200, -10, -1})
    @DisplayName("입력한 숫자가 음수인지 확인")
    void exception_validateInputNumberCount(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    gameScanner.validateNotMinusNumber(input);
                }).withMessage("input으로 입력한 숫자가 음수입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100, 3000})
    @DisplayName("입력한 숫자가 양수인지 확인")
    void ok_validateInputNumberCount(int input) {
        assertDoesNotThrow(() -> {
            gameScanner.validateNotMinusNumber(input);
        });
    }

    private String toInputString(List<Integer> inputNumbers) {
        StringBuilder builder = new StringBuilder();
        for (Integer n : inputNumbers) {
            builder.append(n);
        }
        return builder.toString();
    }
}
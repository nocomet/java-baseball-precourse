package baseball.scanner;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}
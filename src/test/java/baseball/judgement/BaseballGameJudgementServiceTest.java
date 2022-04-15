package baseball.judgement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameJudgementServiceTest {
    BaseballGameJudgementService judgementService = new BaseballGameJudgementService();

    @ParameterizedTest
    @CsvSource(value = {
            "123:456:0:0",
            "123:231:0:3",
            "123:123:3:0",
            "123:328:1:1"}, delimiter = ':')
    void test_judgeResult(String answer, String input, int strikeCount, int ballCount) {
        List<Integer> answerList = splitNumber(answer);
        List<Integer> inputList = splitNumber(input);

        BaseballGameJudgement judgement = judgementService.judgeResult(answerList, inputList);
        assertEquals(strikeCount, judgement.getStrike());
        assertEquals(ballCount, judgement.getBall());
    }

    private List<Integer> splitNumber(String inputString) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            numbers.add(Character.getNumericValue(inputString.charAt(i)));
        }
        return numbers;
    }
}
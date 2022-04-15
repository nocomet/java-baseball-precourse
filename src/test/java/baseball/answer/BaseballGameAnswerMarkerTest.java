package baseball.answer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BaseballGameAnswerMarkerTest 테스트")
class BaseballGameAnswerMarkerTest {
    BaseballGameAnswerMarker answerMarker = new BaseballGameAnswerMarker();

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,10})
    @DisplayName("makeGameAnswer length가 1 이상 10 이하인 경우 테스트")
    void normal_makeGameAnswer(int length) {
        List<Integer> lists = answerMarker.makeGameAnswer(length);
        assertFalse(lists.isEmpty());
        assertEquals(length, lists.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {-100,-10,-5,-1,0})
    @DisplayName("makeGameAnswer length가 0 이하 인 경우")
    void abnormal_makeGameAnswer(int length) {
        List<Integer> lists = answerMarker.makeGameAnswer(length);
        assertTrue(lists.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 15, 100})
    @DisplayName("makeGameAnswer length가 11 이상 인 경우")
    void abnormal2_makeGameAnswer(int length) {
        List<Integer> lists = answerMarker.makeGameAnswer(length);
        assertFalse(lists.isEmpty());
        assertEquals(10, lists.size());
    }
}
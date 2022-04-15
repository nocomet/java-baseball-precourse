package baseball.answer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGameAnswerMarker {

    public List<Integer> makeGameAnswer(int length) {
        if (length <= 0) {
            return Collections.emptyList();
        }

        if (length > 10) {
            length = 10;
        }

        return makeNumberListWithoutOverlap(length);
    }

    private List<Integer> makeNumberListWithoutOverlap(int length) {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() != length) {
            numberSet.add(Randoms.pickNumberInRange(0, 9));
        }
        return new ArrayList<>(numberSet);
    }
}

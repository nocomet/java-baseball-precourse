package baseball.judgement;

import baseball.BaseballGameConf;

import java.util.List;

public class BaseballGameJudgementService {
    public BaseballGameJudgement judgeResult(List<Integer> gameAnswer, List<Integer> inputNumber) {
        BaseballGameJudgement judgement = new BaseballGameJudgement();
        for (int idx = 0; idx < BaseballGameConf.BALL_COUNT ; idx++) {
            Integer target = inputNumber.get(idx);
            BaseballGameScoreType result = judge(target, gameAnswer, idx);
            judgement.count(result);
        }

        return judgement;
    }

    private BaseballGameScoreType judge(Integer target, List<Integer> gameAnswer, int idx) {
        if (target.equals(gameAnswer.get(idx))) {
            return BaseballGameScoreType.STRIKE;
        }

        if (gameAnswer.contains(target)) {
            return BaseballGameScoreType.BALL;
        }

        return BaseballGameScoreType.OUT;
    }
}

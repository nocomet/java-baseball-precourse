package baseball.judgement;

import baseball.BaseballGameConf;

public class BaseballGameJudgement {
    private int strike = 0;
    private int ball = 0;

    public boolean isWin() {
        return strike == BaseballGameConf.BALL_COUNT;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void count(BaseballGameScoreType type) {
        if (BaseballGameScoreType.STRIKE.equals(type)) {
            strike += 1;
        }
        if (BaseballGameScoreType.BALL.equals(type)) {
            ball += 1;
        }
    }
}

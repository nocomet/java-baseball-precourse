package baseball.judgement;

import baseball.BaseballGameConf;

public class BaseballGameJudgement {
    private int strike;
    private int ball;

    public BaseballGameJudgement(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isWin() {
        return strike == BaseballGameConf.BALL_COUNT;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

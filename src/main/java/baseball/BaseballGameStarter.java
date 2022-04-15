package baseball;

import baseball.answer.BaseballGameAnswerMarker;
import baseball.judgement.BaseballGameJudgement;
import baseball.judgement.BaseballGameJudgementService;
import baseball.printer.BaseballGameCommandLinePrinter;
import baseball.printer.BaseballGamePrinter;
import baseball.scanner.BaseballGameMissionUtilsScanner;
import baseball.scanner.BaseballGameScanner;

import java.util.*;

public class BaseballGameStarter {
    private final BaseballGamePrinter printer = new BaseballGameCommandLinePrinter();
    private final BaseballGameScanner scanner = new BaseballGameMissionUtilsScanner();
    private final BaseballGameJudgementService judgementService = new BaseballGameJudgementService();
    private final BaseballGameAnswerMarker answerMarker = new BaseballGameAnswerMarker();
    private final List<Integer> gameAnswer = generateGameAnswer();

    List<Integer> generateGameAnswer() {
        return answerMarker.makeGameAnswer(BaseballGameConf.BALL_COUNT);
    }

    public void start() {
        BaseballGameJudgement judgement;
        do {
            printer.printInputMessage();
            List<Integer> inputNumbers = scanner.scanGameNumber();
            judgement = judgementService.judgeResult(gameAnswer, inputNumbers);
            printer.printHintMessage(judgement.getStrike(), judgement.getBall());
        } while (!judgement.isWin());
        printer.printGameEndMessage();
    }
}

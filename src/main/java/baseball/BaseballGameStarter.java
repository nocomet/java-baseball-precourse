package baseball;

import baseball.judgement.BaseballGameJudgement;
import baseball.judgement.BaseballGameJudgementService;
import baseball.printer.BaseballGameCommandLinePrinter;
import baseball.printer.BaseballGamePrinter;
import baseball.scanner.BaseballGameMissionUtilsScanner;
import baseball.scanner.BaseballGameScanner;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class BaseballGameStarter {

    private final BaseballGamePrinter printer = new BaseballGameCommandLinePrinter();
    private final BaseballGameScanner scanner = new BaseballGameMissionUtilsScanner();
    private final BaseballGameJudgementService judgementService = new BaseballGameJudgementService();
    private final List<Integer> gameNumber = generateGameNumber();

    public List<Integer> generateGameNumber() {
        // todo 0-9까지 중복이 없는 3개의 숫자
        return Arrays.asList(Randoms.pickNumberInRange(0, 9));
    }

    public void start() {
        BaseballGameJudgement judgement;
        do {
            printer.printInputMessage();
            List<Integer> inputNumbers = scanner.scanGameNumber();
            judgement = judgementService.judgeResult(inputNumbers);
            printer.printHintMessage(judgement.getStrike(), judgement.getBall());
        } while (!judgement.isWin());
        printer.printGameEndMessage();
    }
}

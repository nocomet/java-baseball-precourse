package baseball.printer;

public class BaseballGameRestartCommandLinePrinter implements BaseballGameRestartPrinter {

    @Override
    public void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

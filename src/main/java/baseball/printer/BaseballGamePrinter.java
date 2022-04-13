package baseball.printer;

public interface BaseballGamePrinter {
    void printInputMessage();
    void printHintMessage(int strike, int ball);
    void printGameEndMessage();
}

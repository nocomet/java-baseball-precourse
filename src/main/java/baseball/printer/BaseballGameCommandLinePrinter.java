package baseball.printer;

public class BaseballGameCommandLinePrinter implements BaseballGamePrinter {

    @Override
    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printHintMessage(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

        if (ball != 0) {
            System.out.printf("%d볼 ", ball);
        }

        if (strike != 0) {
            System.out.printf("%스트라이크", strike);
        }
    }

    @Override
    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

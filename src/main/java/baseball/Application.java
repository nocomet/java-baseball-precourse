package baseball;

public class Application {
    public static void main(String[] args) {
        boolean isFinish = false;
        while (!isFinish) {
            BaseballGameStarter baseballGameStarter = new BaseballGameStarter();
            baseballGameStarter.start();
        }
    }
}

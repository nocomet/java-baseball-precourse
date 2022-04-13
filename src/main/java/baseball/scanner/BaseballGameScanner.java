package baseball.scanner;

import java.util.List;

public interface BaseballGameScanner {
    List<Integer> scanGameNumber(); // 0~9사이의 값이며 리스트의 갯수는 3
    boolean scanRestartSignal();
}

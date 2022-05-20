import java.util.*;
import java.util.stream.Collectors;


// [] 리팩토링
    // [V] UI와 핵심 로직 분리
    // [V] 함수 흐름 조정하기
    // [] 단위 테스트가 어려운 부분 수정
    // [V] 클래스 단위로 분리하기
// [] 모든 로직에 단위 테스트 만들기

public class BaseballGame {

    List<Integer> nums;
    List<Integer> answer;

    final int NUMS_LENGHT = 3;

    int strike;
    int ball;
    boolean isEnd = false;

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.init();
    }

    private void init() {
        setNums();
        while (!isEnd)
            start();
    }

    private void start() {
        answer = getAnswer();

        if (isGameEnd()) isEnd = true;
        ResultView.printStatus(strike, ball);

        if (isEnd && wantToRestart()) {
            isEnd = false;
            init();
        };
    }

    private boolean wantToRestart() {
        return InputView.inputRestart() == 1;
    }

    private boolean isGameEnd() {
        strike = 0; ball = 0;
        strike = Checker.strikeCount(nums, answer);
        ball = Checker.ballCount(nums, answer);
        return strike == 3;
    }


    private List<Integer> getAnswer() {
        String answer = InputView.inputAnswer();
        return Arrays.stream(answer.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    private void setNums() {
        this.nums = RandomUtil.getRandomNumberList(NUMS_LENGHT);
    }

}

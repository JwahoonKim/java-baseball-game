package domain;

import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Scanner;

public class BaseBallGame {
    Balls answer;
    boolean isEnd;

    public void start() {
        while (!isEnd)
            game();
    }

    public void game() {
        init();

        while (!isEnd) {
            Balls player = InputView.input();
            Result result = Checker.play(answer, player);
            ResultView.resultPrint(result);

            if (result.isEnd()) {
                isEnd = true;
            }
        }

        ResultView.endPrint();
        if (wantToRestart())
            isEnd = false;
    }

    private void init() {
        List<Integer> randomNumbers = RandomUtils.getRandomNumbers();
        answer = new Balls(randomNumbers);
        isEnd = false;
    }

    private boolean wantToRestart() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        return i == 1;
    }

}

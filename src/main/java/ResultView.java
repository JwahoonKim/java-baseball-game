public class ResultView {
    final static String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    static void printStatus(int strike, int ball) {
        if (strike == 3) {
            System.out.println(GAME_CLEAR_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) sb.append(ball).append(" 볼 ");
        if (strike > 0) sb.append(strike).append(" 스트라이크");
        System.out.println(sb);
    }
}

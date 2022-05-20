package view;

import domain.Result;

public class ResultView {
    // 입력에 대한 결과 출력

    // 게임 종료에 대한 정보 출력
    public static void resultPrint(Result result) {
        if (result.isEnd()) {
            System.out.println("3개의 숫자를 모두 맞히쳤습니다! 게임 종료");
        }
        else if (result.isOut()) {
            System.out.println("아웃!");
        }
        else {
            StringBuilder sb = new StringBuilder();
            if (result.ball > 0) sb.append(result.ball).append(" 볼 ");
            if (result.strike > 0) sb.append(result.strike).append(" 스트라이크");
            System.out.println(sb);
        }
    }

    public static void endPrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}

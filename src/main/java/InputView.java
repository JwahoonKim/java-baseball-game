import java.util.Scanner;

public class InputView {

    static String inputAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static int inputRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
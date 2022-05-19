import java.util.*;
import java.util.stream.Collectors;


// [] 리팩토링
    // [] UI와 핵심 로직 분리
    // [] 함수 흐름 조정하기
    // [] 단위 테스트가 어려운 부분 수정
    // [] 클래스 단위로 분리하기
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
//        System.out.println("nums = " + nums);
        while (!isEnd)
            start();
    }

    private void start() {
        answer = getAnswer();

        if (checkAnswer()) isEnd = true;
        printStatus();

        if (isEnd && wantToRestart()) {
            isEnd = false;
            init();
        };
    }

    private boolean wantToRestart() {
        System.out.println("축하합니다!! 짞짞짞짞 다 맞췄어요.");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt() == 1;
    }

    private void printStatus() {
        System.out.println("strike = " + strike);
        System.out.println("ball = " + ball);
    }

    private boolean checkAnswer() {
        strike = 0;
        ball = 0;
        strikeCount();
        ballCount();
        return strike == 3;
    }

    private void strikeCount() {
        for (int i = 0; i < NUMS_LENGHT; i ++) {
            if (nums.get(i) == answer.get(i)) 
                strike += 1;
        }
    }

    private void ballCount() {
        for (int i = 0; i < NUMS_LENGHT; i ++) {
            Integer num = nums.get(i);
            if (answer.contains(num) && !answer.get(i).equals(num)) 
                ball += 1;
        }
    }


    private List<Integer> getAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        return Arrays.stream(answer.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    private void setNums() {
        List<Integer> nums = new ArrayList<>();

        while (nums.size() < 3) {
            int randNumber = makeRandomNumber();
            addNumberIfNumberIsNotDuplicate(nums, randNumber);
        }

        this.nums = nums;
    }

    private void addNumberIfNumberIsNotDuplicate(List<Integer> nums, int randNumber) {
        if (!nums.contains(randNumber)) {
            nums.add(randNumber);
        }
    }

    private static int makeRandomNumber() {
        int randNum = 10;
        while (randNum == 10) randNum = (int)(Math.random() * 10) + 1;
        return randNum;
    }
}

package view;

import domain.Balls;
import domain.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    // 입력하세요 출력 + 입력을 리턴
    public static Balls input() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = sc.nextLine();
        List<Integer> collect = StringUtils.getNumberList(playerInput);
        return new Balls(collect);
    }

}

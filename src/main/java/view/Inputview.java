package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inputview {
    Scanner scanner = new Scanner(System.in);

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public List<Integer> getResult() {
        List<Integer> result = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine().trim();
        String[] splitInput = input.split(",");
        for (String number : splitInput) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}

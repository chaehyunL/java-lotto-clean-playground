package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Inputview {
    Scanner scanner = new Scanner(System.in);

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();
        return validateNumberFormat(input);
    }

    private int validateNumberFormat(String input){
        try{
            return parseInt(input);
        }
        catch(Exception e){
            throw new IllegalArgumentException("[Error]숫자만 입력 가능합니다.");
        }
    }

    public List<Integer> getResult() {
        List<Integer> result = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine().trim();
        String[] splitInput = input.split(",");
        for (String number : splitInput) {
            result.add(validateNumber(number));
        }
        return result;
    }
    private final int Minnumber=1;
    private final int Maxnumber=45;
    public int validateNumber(String input){
        int number=parseInt(input);
        if(number<1||number>45){
            throw new IllegalArgumentException("[ERROR] 숫자는"+Minnumber+"~"+Maxnumber+"까지 입력 가능");
        }
        return number;
    }
}

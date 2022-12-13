package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public Size readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String string = Console.readLine();
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 값을 입력해주세요");
        }

        return new Size(number);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Move readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String string = Console.readLine();

        return new Move(string);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String string = Console.readLine();

        return new Command(string);
    }
}

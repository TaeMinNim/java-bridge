package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> choiceLog) {
        String up = "[";
        String down = "[";
        for(int position = 0; position < choiceLog.size(); position++){
            String bridgeElement = bridge.get(position);
            String choiceElement = choiceLog.get(position);
            if(bridgeElement.equals("U")){
                up += judge(bridgeElement, choiceElement);
                down += "   ";
            } else if(bridgeElement.equals("D")){
                up += "   ";
                down += judge(bridgeElement, choiceElement);
            }

            if(position < bridge.size() - 1) {
                up += "|";
                down += "|";
            }
        }
        up += "]";
        down += "]";

        System.out.println(up);
        System.out.println(down);
    }

    private String judge(String bridgeElement, String choiceElement){
        if(bridgeElement.equals(choiceElement)){
            return " O ";
        }
        return " X ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}

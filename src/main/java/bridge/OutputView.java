package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String up;
    private String down;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> choiceLog) {
        createResultString(bridge, choiceLog);
        System.out.println(up);
        System.out.println(down);
    }

    private void createResultString(List<String> bridge, List<String> choiceLog){
        up = "[";
        down = "[";
        for(int position = 0; position < choiceLog.size(); position++){
            String bridgeElement = bridge.get(position);
            String choiceElement = choiceLog.get(position);
            divideLine(position);
            append(bridgeElement, choiceElement);
        }
        up += "]";
        down += "]";
    }

    private void divideLine(int position){
        if(position == 0){
            return;
        }

        up += "|";
        down += "|";
    }

    private void append(String bridgeElement, String choiceElement){
        if(bridgeElement.equals(choiceElement)) {
            equal(choiceElement);
            return;
        }
        different(choiceElement);
    }

    private void equal(String choiceElement){
        if(choiceElement.equals("U")){
            up += " O ";
            down += "   ";
        } else if(choiceElement.equals("D")){
            up += "   ";
            down += " O ";
        }
    }

    private void different(String choiceElement){
        if(choiceElement.equals("U")){
            up += " X ";
            down += "   ";
        } else if(choiceElement.equals("D")){
            up += "   ";
            down += " X ";
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getBridge(), bridgeGame.getPlayer());
        System.out.println("게임 성공 여부: " + bridgeGame.condition().getName());
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }
}

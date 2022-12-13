package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public final static int RUNNING = 0;
    public final static int GAME_OVER = 1;
    public final static int SUCCESS = 2;

    private Player player = new Player(0, new ArrayList<>());
    private final Bridge bridge;
    private String moveResult;


    public BridgeGame(List<String> bridge){
        this.bridge = new Bridge(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String choice) {
        player.appendLog(choice);
        moveResult = getMoveResult(choice);
        player.move();
    }

    private String getMoveResult(String choice){
        if(bridge.canMove(player.position(), choice)){
            return "O";
        }
        return "X";
    }

    public int condition(){
        if(moveResult.equals("X")){
            return GAME_OVER;
        } else if(bridge.isEndPoint(player.position())){
            return SUCCESS;
        }

        return RUNNING;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}

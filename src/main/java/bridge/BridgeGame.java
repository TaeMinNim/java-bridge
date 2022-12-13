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

    private final Bridge bridge;
    private Player player;
    private String moveResult;
    private int tryCount = 1;

    public BridgeGame(List<String> bridge){
        this.bridge = new Bridge(bridge);
        initGame();
    }

    public BridgeGame(List<String> bridge, Player player){
        this.bridge = new Bridge(bridge);
        this.player = player;
        this.moveResult = getMoveResult(player.lastResult());
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

    public Status condition(){
        if(moveResult.equals("X")){
            return Status.GameOver;
        } else if(bridge.isEndPoint(player.position())){
            return Status.Success;
        }

        return Status.Running;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        initGame();
    }

    private void initGame(){
        this.player = new Player(0, new ArrayList<>());
    }

    public List<String> getBridge(){
        return bridge.getBridge();
    }

    public List<String> getPlayer(){
        return player.getChoiceLog();
    }

    public int getTryCount(){
        return tryCount;
    }
}

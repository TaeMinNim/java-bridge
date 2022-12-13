package bridge;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void run(){
        setup();
        do{
            gameStart();
            if(bridgeGame.condition() == Status.GameOver && retry()){
                bridgeGame.retry();
                continue;
            }
            break;
        } while(bridgeGame.condition() != Status.Success);
        outputView.printResult(bridgeGame);
    }

    private boolean retry(){
        Command command = inputView.readGameCommand();
        return command.getCommand().equals("R");
    }

    private void setup(){
        Size size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size.getSize());
        bridgeGame = new BridgeGame(bridge);
    }

    private void gameStart(){
        do{
            Move move = inputView.readMoving();
            bridgeGame.move(move.getMove());
            outputView.printMap(bridgeGame.getBridge(), bridgeGame.getPlayer());
        }
        while(bridgeGame.condition() == Status.Running);
    }
}

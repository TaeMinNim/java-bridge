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
        Command command = readCommand();
        return command.getCommand().equals("R");
    }

    private Command readCommand(){
        Command command = null;
        while(command == null) {
            try {
                command = inputView.readGameCommand();
            } catch (IllegalArgumentException e){
                outputView.printError(e);
            }
        }

        return command;
    }

    private void setup(){
        Size size = readSize();
        List<String> bridge = bridgeMaker.makeBridge(size.getSize());
        bridgeGame = new BridgeGame(bridge);
    }

    private Size readSize(){
        Size size = null;
        while(size == null) {
            try {
                size = inputView.readBridgeSize();
            }catch (IllegalArgumentException e){
                outputView.printError(e);
            }
        }

        return size;
    }

    private void gameStart(){
        do{
            Move move = readMove();
            bridgeGame.move(move.getMove());
            outputView.printMap(bridgeGame.getBridge(), bridgeGame.getPlayer());
        }
        while(bridgeGame.condition() == Status.Running);
    }

    private Move readMove(){
        Move move = null;
        while(move == null) {
            try {
                move = inputView.readMoving();
            } catch (IllegalArgumentException e){
                outputView.printError(e);
            }
        }

        return move;
    }
}

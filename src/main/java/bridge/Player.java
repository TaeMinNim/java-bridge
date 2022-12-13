package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final static int START_POINT = -1;
    private int position;
    private List<String> choiceLog;

    public Player(){
        this.position = START_POINT;
        this.choiceLog = new ArrayList<>();
    }

    public Player(int position, List<String> choiceLog){
        this.position = position;
        this.choiceLog = choiceLog;
    }

    public void appendLog(String choice){
        choiceLog.add(choice);
    }

    public void move(){
        position++;
    }

    public int position(){
        return position;
    }

    public String lastResult(){
        return choiceLog.get(choiceLog.size() - 1);
    }

    public List<String> getChoiceLog(){
        return choiceLog;
    }
}

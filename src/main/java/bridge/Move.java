package bridge;

public class Move {
    private String move;

    public Move(String move){
        validData(move);
        this.move = move;
    }

    private void validData(String move){
        if(!(move.equals("U") || move.equals("D"))){
            throw new IllegalArgumentException("입력은 U or D만 입력 가능합니다");
        }
    }

    public String getMove(){
        return move;
    }
}

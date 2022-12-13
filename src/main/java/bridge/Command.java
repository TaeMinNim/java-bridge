package bridge;

public class Command {
    private String command;

    public Command(String command){
        validData(command);
        this.command = command;
    }

    private void validData(String command){
        if(!(command.equals("R") || command.equals("Q"))){
            throw new IllegalArgumentException("입력은 R or Q만 입력 가능합니다");
        }
    }

    public String getCommand(){
        return command;
    }
}
